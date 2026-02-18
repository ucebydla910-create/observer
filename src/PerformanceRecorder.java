package observers;

import observer.Observer;
import observer.ServerMonitor;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Записывает историю изменения CPU в CSV-файл.
 */
public class PerformanceRecorder implements Observer {
    private static final String FILE_NAME = "metrics.csv";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public PerformanceRecorder() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            if (new java.io.File(FILE_NAME).length() == 0) {
                writer.println("timestamp,server,cpu");
            }
        } catch (IOException e) {
            System.err.println("Не удалось создать заголовок CSV: " + e.getMessage());
        }
    }

    @Override
    public void update(ServerMonitor server) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            String timestamp = LocalDateTime.now().format(FORMATTER);
            writer.printf("%s,%s,%.1f\n", timestamp, server.getName(), server.getCpuLoad());
        } catch (IOException e) {
            System.err.println("Ошибка записи в CSV: " + e.getMessage());
        }
    }
}
