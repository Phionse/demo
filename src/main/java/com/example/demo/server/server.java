package com.example.demo.server;

// import com.alibaba.fastjson.JSONArray;
// import com.alibaba.fastjson.JSONObject;
// import org.apache.kafka.common.protocol.types.Field;

// import javax.tools.Tool;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
// import java.util.Random;
import java.util.Scanner;

public class server {
        public static void main(String[] args) {
            try {
                List<String> jsonObjectList = new ArrayList<>();
                Scanner scanner = new Scanner(new File("/Users/mr.ma/Downloads/地震局文件/震安居/faults.json"));
                int x = 0;
                while (scanner.hasNextLine()) {
                    jsonObjectList.add(scanner.next());
                    x++;
                }
                System.out.printf(String.valueOf(x));
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }



    }