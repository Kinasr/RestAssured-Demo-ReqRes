package helpers;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ReadFromExcelSheet {
    private final int numOfRows, numOfColumns;
    private final XSSFSheet sheet;

    public ReadFromExcelSheet(String fileName, String sheetName) throws IOException, InvalidFormatException {
        File file = new File("D:\\My_Projects\\API\\Rest_Assured_Software_Quality_Academy_01\\src\\main\\resources\\"
                + fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(sheetName);
        numOfRows = sheet.getPhysicalNumberOfRows();
        System.out.println(numOfRows);
        numOfColumns = sheet.getRow(0).getLastCellNum();
    }

    public Object[][] readDataFromExcel() {

        Object[][] userData = new Object[numOfRows - 1][numOfColumns];

        for(int i = 1; i < numOfRows; i++) {
            for(int j = 0; j <numOfColumns; j++) {
                XSSFRow row = sheet.getRow(i);

//                DataFormatter formatter = new DataFormatter();
//                userData[i-1][j] = formatter.formatCellValue(row.getCell(j));

                String cellData = row.getCell(j).toString();
                if (cellData.matches("\\d+\\.\\d+")){
                    userData[i-1][j] = cellData.replaceAll("\\.\\d+$", "");
                    continue;
                }
                userData[i-1][j] = row.getCell(j).toString();

            }
        }
        return userData;
    }

    public Object[] reedSingleRowFromExcel(String)
}
