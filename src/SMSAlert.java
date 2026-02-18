package observers;

import observer.Observer;
import observer.ServerMonitor;

/**
 * Оповещение по SMS.
 * Срабатывает при статусе OFFLINE.
 */
public class SMSAlert implements Observer {
    private final String phone = "+7-999-123-45-67";

    @Override
    public void update(ServerMonitor server) {
        if ("OFFLINE".equals(server.getStatus())) {
            System.out.printf("📱 SMS to %s: Server %s is DOWN!\n",
                    phone, server.getName());
        }
    }
}
