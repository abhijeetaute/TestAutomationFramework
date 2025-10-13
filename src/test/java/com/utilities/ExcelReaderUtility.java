package com.utilities;

import com.ui.pojos.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {
    public static Iterator<User> readExcelFile(String fileName) {
        XSSFWorkbook workbook;
        XSSFSheet sheet;
        Row row;
        User user;
        List<User> list;
        try {
            workbook=new XSSFWorkbook(new File(System.getProperty("user.dir")+"//testdata//"+fileName));
            sheet=workbook.getSheet("loginTestData");
            Iterator<Row> rowItertor=sheet.iterator();
            rowItertor.next();
            list=new ArrayList<>();
            while(rowItertor.hasNext()){
               row=rowItertor.next();
               user=new User(row.getCell(0).toString(),row.getCell(1).toString());
               list.add(user);
            }
            workbook.close();
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(e);
        }
        return list.iterator();
    }
}
