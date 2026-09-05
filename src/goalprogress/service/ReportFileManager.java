package goalprogress.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReportFileManager {

    public void save(String report, String fileName) {
        try {
            Path folder = Path.of("reports");

            Files.createDirectories(folder);

            Path file = folder.resolve(fileName);

            Files.writeString(file, report);

            System.out.println("Report saved in: " + file);

        } catch (IOException e) {
            System.out.println("Could not save report.");
            System.out.println(e.getMessage());
        }
    }
}