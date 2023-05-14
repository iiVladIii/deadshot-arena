package auth.logs;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LogsList {
    private static List<Log> logsList;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final File file = new File("src/logs.json");

    public static void loadLogs() {
        try {
            logsList = objectMapper.readValue(file, new TypeReference<>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showLogs() {
        for (Log log : logsList) {
            System.out.println(log.toString());
        }
    }

    public static List<Log> getLogsList() {
        return logsList;
    }

    public static void addLogToList(Log log) {
        logsList.add(log);
    }

    public static void saveLogsFile() {
        try {
            objectMapper.writeValue(file, logsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
