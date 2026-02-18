import observer.ServerMonitor;
import observers.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("🚀 Запуск системы мониторинга...\n");

        ServerMonitor server = new ServerMonitor("web-server-01");

        EmailAlert emailAlert = new EmailAlert();
        SMSAlert smsAlert = new SMSAlert();
        DashboardLogger dashboardLogger = new DashboardLogger();
        PerformanceRecorder performanceRecorder = new PerformanceRecorder(); // дополнительный

        server.attach(emailAlert);
        server.attach(smsAlert);
        server.attach(dashboardLogger);
        server.attach(performanceRecorder);
        System.out.println();

        server.setCpuLoad(92.0);
        server.setMemoryUsage(45.0);
        server.setStatus("OFFLINE");
        System.out.println();

        server.detach(emailAlert);
        System.out.println("(EmailAlert больше не получает уведомления)\n");

        server.setCpuLoad(95.0);
        server.setStatus("ONLINE");
        System.out.println();

        System.out.println("✅ Работа завершена. История CPU сохранена в metrics.csv");
    }
}
