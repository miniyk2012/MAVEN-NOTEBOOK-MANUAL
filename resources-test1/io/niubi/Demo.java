package io.niubi;

import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

// javac io/niubi/Demo.java   
// java io.niubi.Demo
class Demo {
    public static void main(String[] args) {
        File file = new File("resource.txt");   // 使用相对路径定位
        BufferedReader reader = null;  
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;  
            while ((tempString = reader.readLine()) != null) {  
                // 显示行号  
                System.out.println("line " + line + ": " + tempString);  
                line++;  
            } 
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    }
}