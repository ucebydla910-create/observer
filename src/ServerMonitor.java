package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Конкретный субъект — сервер.
 * Хранит состояние и уведомляет наблюдателей об изменениях.
 */
public class ServerMonitor implements Subject {
    private final String name;
    private double cpuLoad;       // в процентах
    private double memoryUsage;    // в процентах
    private String status;         // ONLINE, OFFLINE, MAINTENANCE

    private final List<Observer> observers = new ArrayList<>();

    public ServerMonitor(String name) {
        this.name = name;
        this.cpuLoad = 0.0;
        this.memoryUsage = 0.0;
        this.status = "ONLINE";
    }

    public String getName() { return name; }
    public double getCpuLoad() { return cpuLoad; }
    public double getMemoryUsage() { return memoryUsage; }
    public String getStatus() { return status; }

    public void setCpuLoad(double cpuLoad) {
        this.cpuLoad = cpuLoad;
        System.out.printf("[ИЗМЕНЕНИЕ] Сервер '%s' CPU: %.1f%%\n", name, cpuLoad);
        notifyObservers();
    }

    public void setMemoryUsage(double memoryUsage) {
        this.memoryUsage = memoryUsage;
        System.out.printf("[ИЗМЕНЕНИЕ] Сервер '%s' память: %.1f%%\n", name, memoryUsage);
        notifyObservers();
    }

    public void setStatus(String status) {
        this.status = status;
        System.out.printf("[ИЗМЕНЕНИЕ] Сервер '%s' статус: %s\n", name, status);
        notifyObservers();
    }

    @Override
    public void attach(Observer o) {
        if (o != null && !observers.contains(o)) {
            observers.add(o);
            System.out.println("Наблюдатель " + o.getClass().getSimpleName() + " подписан.");
        }
    }

    @Override
    public void detach(Observer o) {
        if (o != null && observers.remove(o)) {
            System.out.println("Наблюдатель " + o.getClass().getSimpleName() + " отписан.");
        }
    }

    @Override
    public void notifyObservers() {
        if (observers.isEmpty()) {
            return;
        }
        for (Observer o : observers) {
            o.update(this);
        }
    }
}
