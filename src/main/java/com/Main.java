package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTasks = Integer.parseInt(reader.readLine());
        try {
            for (int i = 0; i < numberOfTasks; i++) {
                executor.execute(new My_Crawler(new DataLinks("https://www.youtube.com/")));
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
        executor.shutdown();
    }
}
