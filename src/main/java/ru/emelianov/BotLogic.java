package ru.emelianov;

/**
 * Класс организации обработки сообщения
 *
 * @author mikhailemv
 * @since 09.11.2023
 */
public class BotLogic {

    private final Bot bot;

    public BotLogic(Bot bot) {
        this.bot = bot;
    }

    /**
     * Обработчки сообщений от юзера и отправка ему ответа
     *
     * @param message сообщение пользователя
     */
    void handleMessage(Message message) {
        String reply = "Ваше сообщение: " + message.text();
        Message botReplyMessage = new Message(message.chatId(), reply);
        bot.sendMessage(botReplyMessage);
    }
}
