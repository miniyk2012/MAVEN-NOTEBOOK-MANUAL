package io;

import java.io.File;
import java.io.BufferedReader;
import java.net.URL;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.nio.charset.Charset;

// java -cp resources/:conf/:. io.Demo
class Demo2 {
    public static void main(String[] args) {
        System.out.println(Demo2.class.getResource(""));
        System.out.println(Demo2.class.getResource("/"));
        URL resource = Demo2.class.getResource("/resources/resource.txt");
        URL conf = Demo2.class.getResource("/conf/empty.conf");
        URL config = Demo2.class.getResource("config.txt"); 
        BufferedReader reader = null;  
        BufferedReader reader2 = null;  
        try {
            InputStream resourceStream = resource.openStream();
            reader = new BufferedReader(new InputStreamReader(resourceStream, Charset.forName("UTF-8")));
            String tempString = null;
            int line = 1;  
            while ((tempString = reader.readLine()) != null) {  
                // 显示行号  
                System.out.println("line " + line + ": " + tempString);  
                line++;  
            } 

            InputStream configStream = config.openStream(); 
            reader2 = new BufferedReader(new InputStreamReader(configStream, Charset.forName("UTF-8")));
            String tempString2 = null;
            int line2 = 1;  
            while ((tempString2 = reader2.readLine()) != null) {  
                // 显示行号  
                System.out.println("line " + line2 + ": " + tempString2);  
                line2++;  
            } 
        }catch (IOException e) {  
                e.printStackTrace();  
         } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
            if (reader2 != null) {  
                try {  
                    reader2.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    }
}