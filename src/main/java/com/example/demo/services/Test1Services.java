package com.example.demo.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.*;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Test;

@Service
@Transactional
public class Test1Services {

	@Value("${app.upload.file:${user.home}}")
	public String EXCEL_FILE_PATH;

	Workbook workbook;

	public List<Test> getExcelDataAsList(String filename)
	{
		String file="D:/ExcelFile/"+filename;
		List<Test> list = new ArrayList<Test>();
		DataFormatter dataFormatter = new DataFormatter();
		try {
			workbook = WorkbookFactory.create(new File(file));
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		System.out.println("-------Workbook has '" + workbook.getNumberOfSheets() + "' Sheets-----");
		
		Sheet sheet = workbook.getSheetAt(0);
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		System.out.println("-------Sheet has '"+noOfColumns+"' columns------");
		for (Row row : sheet) {		
				Test t=new Test(dataFormatter.formatCellValue(row.getCell(0)) ,dataFormatter.formatCellValue(row.getCell(1)),dataFormatter.formatCellValue(row.getCell(2)),dataFormatter.formatCellValue(row.getCell(3)),dataFormatter.formatCellValue(row.getCell(4)));
				putans(Integer.parseInt(dataFormatter.formatCellValue(row.getCell(5))));
				list.add(t);			
		}
		System.out.println(list.size());
		for(Test tes:list)
		{
			System.out.println(tes.question);
			System.out.println(tes.option1);
			System.out.println(tes.option2);
			System.out.println(tes.option3);
			System.out.println(tes.option4);
		}
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	List<Integer> ans=new LinkedList<Integer>();
	public void putans(int a)
	{
		ans.add(a);
	}
	
	public List<Integer> getAns()
	{
		return ans;
	}
	
	public int result(Integer a[])
	{
		int length=a.length;
		int count=0;
		for(int i=0;i<length;i++)
		{
			if(a[i]==ans.get(i))
			{
				count++;
			}
		}
		return count;
	}
	
	
	@Value("${app.upload.dir:${user.home}}")
    public String uploadDir;
	
	 public void uploadFile(MultipartFile file) {

	        try {
	            Path copyLocation = Paths
	            		.get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
	            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Could not store file " + file.getOriginalFilename()
	                + ". Please try again!");
	        }
	    }
	 
	 static int row=0;
	 
	 public void addResult(String filename,String name,String mobile,String email,int marks)
	 {
		 String file="D:/ExcelFile/"+filename+"Result.xls";			
			try {  
				Workbook workbook = new HSSFWorkbook();  			
				Sheet sheet = workbook.createSheet("January"); 			
				Row rowhead = sheet.createRow(row++); 			
				rowhead.createCell(0).setCellValue(name);  
				rowhead.createCell(1).setCellValue(mobile);  
				rowhead.createCell(2).setCellValue(email);  
				rowhead.createCell(3).setCellValue(marks);
				FileOutputStream fileOut = new FileOutputStream(file);  
				workbook.write(fileOut); 
				fileOut.close(); 
				workbook.close();    
				System.out.println("Result save Successfully");  
			}
		  catch(Exception ex)
			{
			  ex.printStackTrace();
			} 
	 }
	 
	 public void createResultFile(String filename)
	 {  
		 String file="D:/ExcelFile/"+filename+"Result.xls";
		try {  
			HSSFWorkbook workbook = new HSSFWorkbook();  			
			HSSFSheet sheet = workbook.createSheet("January");  
			HSSFRow rowhead = sheet.createRow((short)0); 			
			rowhead.createCell(0).setCellValue("Name");  
			rowhead.createCell(1).setCellValue("Mobile Number");  
			rowhead.createCell(2).setCellValue("Email Id");  
			rowhead.createCell(3).setCellValue("Correct Answers");
			FileOutputStream fileOut = new FileOutputStream(file);  
			workbook.write(fileOut); 
			fileOut.close(); 
			workbook.close();    
			System.out.println("Excel file has been generated successfully.");  
		}
	  catch(Exception ex)
		{
		  ex.printStackTrace();
		}
	 }
	 
	  public static List<Test> excelToTest(String filename) {
		  String file="D:/ExcelFile/"+filename;
		    try {
		      Workbook workbook = new XSSFWorkbook(file);

		      Sheet sheet = workbook.getSheetAt(0);
		      Iterator<Row> rows = sheet.iterator();

		      List<Test> testlist = new ArrayList<Test>();

		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }
		        Test test = new Test();
		          test.question = currentRow.getCell(0).toString();
		          test.option1 = currentRow.getCell(1).toString();
		          test.option2 = currentRow.getCell(2).toString();
		          test.option3 = currentRow.getCell(3).toString();
		          test.option4 = currentRow.getCell(4).toString();		        
		        testlist.add(test);
		      }

		      workbook.close();

		      return testlist;
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
		  }
}


