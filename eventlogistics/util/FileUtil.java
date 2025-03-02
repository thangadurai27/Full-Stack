package com.eventlogistics.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    public static void writeReportToFile(String fileName, String content) {
        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
            System.out.println("Report saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
