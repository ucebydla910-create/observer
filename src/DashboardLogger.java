package observers;

import observer.Observer;
import observer.ServerMonitor;

/**
 * Логирует полное состояние сервера в формате JSON.
 * Срабатывает всегда.
 */
public class DashboardLogger implements Observer {
    @Override
    public void update(ServerMonitor server) {
        String json = String.format(
                "{\"name\":\"%s\",\"cpu\":%.1f,\"memory\":%.1f,\"status\":\"%s\"}",
                server.getName(), server.getCpuLoad(), server.getMemoryUsage(), server.getStatus()
        );
        System.out.println("📊 Dashboard: " + json);
    }
}
