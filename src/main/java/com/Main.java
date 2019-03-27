package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {


//        List<String> list = new ArrayList<String>(); //1
//        list.add("https://www.youtube.com/");
//        list.add("https://www.digg.com/");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTasks = Integer.parseInt(reader.readLine());
        try {
            for (int i = 0; i < numberOfTasks; i++) {
                (new My_Crawler(new DataLinks("https://www.youtube.com/"))).start();
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}
