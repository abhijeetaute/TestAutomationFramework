package com.ui.dataprovider;

import com.google.gson.Gson;
import com.ui.pojos.TestData;
import com.ui.pojos.User;
import com.utilities.CSVReaderUtility;
import com.utilities.ExcelReaderUtility;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTestDataProvider {

    @DataProvider(name="loginTestDataProvider")
    public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
        Gson gson=new Gson();
        File testDataFile=new File(System.getProperty("user.dir")+"\\testData\\loginData.json");
        FileReader fileReader=new FileReader(testDataFile);
        TestData data=gson.fromJson(fileReader, TestData.class);

        List<Object[]> dataObject=new ArrayList<>();
        for(User user:data.getData()){
            dataObject.add(new Object[] {user}); // adding user object to list dataObject which store array of Object
        }
        return dataObject.iterator(); // returning iterator to dataObject list
    }

    @DataProvider(name="csvDataProvider")
    public Iterator<User> loginCSVDataProvider(){
       return CSVReaderUtility.readCSVFile("loginData");
    }

    @DataProvider(name="excelDataProvider")
    public Iterator<User> loginExcelDataProvider(){
        return ExcelReaderUtility.readExcelFile("loginData.xlsx");
    }
}
