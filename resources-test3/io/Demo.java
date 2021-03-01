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
class Demo {
    public static void main(String[] args) {
        URL resource = Demo.class.getClassLoader().getResource("resource.txt");
        URL conf = Demo.class.getClassLoader().getResource("empty.conf");
        BufferedReader reader = null;  
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
        }catch (IOException e) {  
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