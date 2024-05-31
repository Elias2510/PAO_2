package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditService {
    private static final String FILE_PATH = "/Users/eliasmilosi/Desktop/PAO_2/src/main/java/org/example/audit.csv";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void logAction(String actionName) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            String timestamp = LocalDateTime.now().format(formatter);
            writer.append(actionName).append(",").append(timestamp).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
