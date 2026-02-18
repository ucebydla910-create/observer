package observer;

/**
 * Наблюдатель.
 * Получает обновления от субъекта.
 */
public interface Observer {
    /**
     * Вызывается субъектом при изменении состояния.
     * @param server субъект (конкретный сервер), передаётся для получения данных
     */
    void update(ServerMonitor server);
}
