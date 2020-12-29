package com.vyTrack.utillities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

/*

HOW DO WE READ FROM THE PROPERTIES?
•	There is an existing java class called Properties that helps us read properties file.
•	Properties class was created to read ".properties" type of file
•	When we create and object of this class, and load the configuration.properties file into this object,
    it has its ready methods to help us read key=value format.
       WHY DO WE NEED? WHAT ARE WE GOING TO DO WITH IT?
•	#1 REASON : Is not having to hardcode your configuration test data into your code itself.
•	#2 REASON : Easy to fix any issue. You just need to go 1 file, (configuration.properties) and fix it there
•	#3 REASON: East to do DATA DRIVEN TESTING

          Step by step how to read from properties file:
1- Create an instance of Properties class       private static Properties properties = new Properties();
2- Get the path of the configuration.properties file      String path = "configuration.properties";
3- We need to open the configuration.properties file in JVM memory       FileInputStream file = new FileInputStream(path);
4- We have to load the file we opened using fileInputStream, to properties object.       properties.load(file);
5- We close the opened file  (by FileInputStream)      file.close();

All of the logic above goes into static block. But why?
•	IF something is static what happens to it? When Does it run?
•	It runs ONCE and before everything else.
•	All the important information we store in configuration.properties file must be ready before we start running our tests.
We put everything in try/catch just because FileInputStream constructor, and properties object has checked exception.
That why we handle with try/catch.


 */

    //1- we created properties object
    private static Properties properties ;

    static {
        //2- get the path and store in String, or directly pass into fileInputStream obj
        String path = "configuration.properties";

        try {
            //3- we need to open the file
            FileInputStream file = new FileInputStream(path);
            //4- we need to load the file to properties object
            properties=new Properties();
            properties.load(file);

            //5- close.file
            file.close();
        } catch (IOException e) {
            System.out.println("The path can not be found");
            e.printStackTrace();
        }
    }

    //Our own custom method to read and get values from configuration.properties file
    public static String getProperty(String key) {
        return properties.getProperty(key);

    }


}
