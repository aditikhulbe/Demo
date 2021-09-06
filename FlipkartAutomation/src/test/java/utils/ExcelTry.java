
package utils;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.util.NumberToTextConverter;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Iterator;

	public class ExcelTry {

	  // Identify test cases column by scanning the entire 1st row
	  // once column is identified then scan entire testcases column to
	  // identify purchase testcases row
	  // After you grab purchase test case row =pull all the data of that row and feed into test

	  public ArrayList<String> getData(String testcasesName) throws IOException {
	    /**
	     * Strategy to Access Excel Data
	     */

	    ArrayList<String> arrayList=new ArrayList<>();
	    //FileInputStream argument

	    FileInputStream file=new FileInputStream("src/main/resources/TestData.xlsx");

	    //Create object for XSSFWorkbook class
	    XSSFWorkbook workbook=new XSSFWorkbook(file); //access to workbook

	    //Get Access to sheet
	    int sheet= workbook.getNumberOfSheets();//give the count of all the sheet present in the workbook
	    for(int i=0;i<sheet;i++){

	      if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1")){
	        //return type of this getSheetAt() method is XSSFSheet
	        XSSFSheet sheet1= workbook.getSheetAt(i);//return the index of the sheet
	        //give the access of particular sheet

	        // Identify test cases column by scanning the entire 1st row
	        Iterator<Row> row=sheet1.iterator();//Get Access to all rows of Sheet(sheet is collection of rows)
	        Row firstRow=row.next();//Access to specific row from all rows

	        Iterator<Cell> cellRow=firstRow.cellIterator();//Get Access to all cells of Row (This is a collection of cells)
	        cellRow.next();//read all the cell of the one row

	        int k=0;
	        int column=0;
	        while(cellRow.hasNext())
	        {//hasNext return cell is present or not
	          Cell value=cellRow.next();
	          if(value.getStringCellValue().equalsIgnoreCase("TestCases")) // string value present in the cell value
	          {
	            //Desired column
	            column=k;
	          }
	          k++;
	        }
	        System.out.println(column);

	        // once column is identified then scan entire testcases column to identify purchase testcases row
	        while (row.hasNext()){
	          Row r= row.next();
	          if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasesName)){

	            //After you grab purchase test case row =pull all the data of that row and feed into test
	            Iterator<Cell> cv= r.cellIterator();
	            while(cv.hasNext())
	            {
	              //for the value of the integer or we can use cell type
	              Cell c=cv.next();
	              if(c.getCellTypeEnum() == CellType.STRING){
	                arrayList.add(c.getStringCellValue());
	              }
	              else {
	                arrayList.add(NumberToTextConverter.toText(c.getNumericCellValue()));
	              }
	              // System.out.println(cv.next().getStringCellValue());
	            }
	          }
	        }
	      }
	    }
	    return arrayList;
	  }

	  public void writeData(String[] dataToWrite) throws IOException {
	    FileInputStream file=new FileInputStream("src/main/resources/TestData.xlsx");

	    //Create object for XSSFWorkbook class
	    XSSFWorkbook workbook=new XSSFWorkbook(file); //access to workbook

	    //Get Access to sheet
	    int sheet= workbook.getNumberOfSheets();//give the count of all the sheet present in the workbook
	    for (int i = 0; i < sheet; i++) {

	      if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
	        // return type of this getSheetAt() method is XSSFSheet
	        XSSFSheet sheet1 = workbook.getSheetAt(i);

	        //Get the current count of rows in excel file
	        int rowCount = sheet1.getLastRowNum()-sheet1.getFirstRowNum();

	        //Get the first row from the sheet
	        Row row = sheet1.getRow(0);

	        //Create a new row and append it at last of sheet
	        Row newRow = sheet1.createRow(rowCount+1);

	        //Create a loop over the cell of newly created Row

	        for(int j = 0; j < row.getLastCellNum(); j++){

	          //Fill data in row
	          Cell cell = newRow.createCell(j);
	          cell.setCellValue(dataToWrite[j]);
	        }

//	        file.close();

	        //Create an object of FileOutputStream class to create write data in excel file
	        FileOutputStream outputStream = new FileOutputStream("src/main/resources/TestData.xlsx");

	        //write data in the excel file
	        workbook.write(outputStream);

	        //close output stream
	        outputStream.close();
	      }
	    }
	  }

	}


