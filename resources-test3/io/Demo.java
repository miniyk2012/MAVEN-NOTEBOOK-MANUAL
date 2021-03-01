package io;

import java.io.File;
import java.io.BufferedReader;
import java.net.URL;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.nio.charset.Charset;

// javac io/*.java
// java io.Demo

// # java -cp resources/:conf/:. io.Demo  # 这样的话, 等于增加了2个classpath, 那么getResource("resource.txt")就可以了
class Demo {
    public static void main(String[] args) {
        System.out.println(Demo.class.getClassLoader().getResource(""));
        System.out.println(Demo.class.getClassLoader().getResource("/"));
        URL resource = Demo.class.getClassLoader().getResource("resources/resource.txt");
        URL conf = Demo.class.getClassLoader().getResource("conf/empty.conf");
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

            InputStream confStream = conf.openStream();
            reader2 = new BufferedReader(new InputStreamReader(confStream, Charset.forName("UTF-8")));
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
        }  
    }
}