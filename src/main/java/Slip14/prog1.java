/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slip14;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class prog1 {
    private static final String SEARCH_STRING = "prog1"; // Replace 'your_search_string' with the string to be searched

    public static void main(String[] args) {
        File currentFolder = new File(System.getProperty("user.dir"));
        File[] files = currentFolder.listFiles();

        ExecutorService executorService = Executors.newFixedThreadPool(files.length);

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                executorService.execute(new SearchTask(file, SEARCH_STRING));
            }
        }

        executorService.shutdown();
    }

    static class SearchTask implements Runnable {
        private final File file;
        private final String searchString;

        public SearchTask(File file, String searchString) {
            this.file = file;
            this.searchString = searchString;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                int lineNumber = 0;
                while ((line = reader.readLine()) != null) {
                    lineNumber++;
                    if (line.contains(searchString)) {
                        System.out.println("Found in file: " + file.getName() + " at line: " + lineNumber);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
