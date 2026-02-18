package observers;

import observer.Observer;
import observer.ServerMonitor;

/**
 * Оповещение по email.
 * Срабатывает при загрузке CPU > 85%.
 */
public class EmailAlert implements Observer {
    private final String email = "admin@company.com";

    @Override
    public void update(ServerMonitor server) {
        if (server.getCpuLoad() > 85) {
            System.out.printf("📧 Email to %s: Server %s CPU overload: %.1f%%\n",
                    email, server.getName(), server.getCpuLoad());
        }
    }
}
