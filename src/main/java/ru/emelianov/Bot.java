package ru.emelianov;

/**
 * Интерфейс бота
 *
 * @author mikhailemv
 * @since 09.11.2023
 */
public interface Bot {

    /**
     * Отправка сообщением
     *
     * @param message сообщение
     *
     */
    void sendMessage(Message message);
}
