package audit;


import services.DocumentException;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class Audit {
    public static void writeAuditCSV(String actionName) throws DocumentException {
        Path pathToFile = Paths.get("Logs.csv");

        try {
            BufferedWriter bwr = Files.newBufferedWriter(pathToFile, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            bwr.write("\n" + actionName + "," + new Date());
            bwr.close();
        } catch (FileNotFoundException e) {
            throw new DocumentException("File Logs.csv not found!");
        } catch (IOException e) {
            throw new DocumentException("Error while writing in the logs file!", e);
        }
    }
}
