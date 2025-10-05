package com.utilities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojos.User;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class CSVReaderUtility {

    public static Iterator<User> readCSVFile(String fileName) {
        File csvFile=new File(System.getProperty("user.dir")+"\\testData\\"+fileName+".csv");
        FileReader fileReader= null;
        String[] line;
        ArrayList<User> list=new ArrayList<>();
        User userData;
        CSVReader csvReader;
        try {
            fileReader = new FileReader(csvFile);
            csvReader = new CSVReader(fileReader);
            csvReader.readNext();

            while ((line = csvReader.readNext()) != null) {
                userData = new User(line[0], line[1]);
                list.add(userData);
            }
        } catch (FileNotFoundException e) {
                throw new RuntimeException(e);

        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
        return list.iterator();







    }
}
