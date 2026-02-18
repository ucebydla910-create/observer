package observer;

/**
 * Субъект (наблюдаемый объект).
 * Определяет методы для управления подписчиками (наблюдателями).
 */
public interface Subject {
    /**
     * Подписать наблюдателя.
     * @param o наблюдатель
     */
    void attach(Observer o);

    /**
     * Отписать наблюдателя.
     * @param o наблюдатель
     */
    void detach(Observer o);

    /**
     * Уведомить всех подписанных наблюдателей об изменении состояния.
     */
    void notifyObservers();
}
