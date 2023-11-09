package ru.emelianov;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;

/**
 * Телеграм-бот, который присылает сообщение в ответ на сообщение юзера
 *
 * @author mikhailemv
 * @since 09.11.2023
 *
 */
public class MyTelegramBot implements Bot {

    private TelegramBot botApi;

    private final BotLogic botLogic = new BotLogic(this);

    /**
     * Регистрация бота и его запуск
     *
     * @param token конкретный токен бота
     */
    public void register(String token) {
        botApi = new TelegramBot(token);
        botApi.setUpdatesListener(updates -> {
            updates.forEach(update -> {
                botLogic.handleMessage(new Message(update.message().chat().id(), update.message().text()));
            });
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

    @Override
    public void sendMessage(Message message) {
        botApi.execute(new SendMessage(message.chatId(), message.text()));
    }
}
