package ru.emelianov;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.intent.Intent;

import java.util.Optional;

/**
 * Дискорд-бот, который присылает сообщение в ответ на сообщение юзера
 *
 * @author mikhailemv
 * @since 09.11.2023
 */
public class MyDiscordBot implements Bot {

    private DiscordApi discordApi;

    private final BotLogic botLogic = new BotLogic(this);

    /**
     * Регистрация бота и его запуск
     *
     * @param token конкретный токен бота
     */
    public void register(String token) {
        discordApi = new DiscordApiBuilder().setToken(token).addIntents(Intent.MESSAGE_CONTENT).login().join();
        discordApi.addMessageCreateListener(event -> {
            if (!event.getMessageAuthor().isBotUser()) {
                Message message = new Message(event.getChannel().getId(), event.getMessageContent());
                botLogic.handleMessage(message);
            }
        });
    }

    @Override
    public void sendMessage(Message message) {
        if (discordApi.getChannelById(message.chatId()).isPresent()) {
            Optional<TextChannel> textChannel = discordApi.getChannelById(message.chatId()).get().asTextChannel();
            textChannel.ifPresent(channel -> channel.sendMessage(message.text()));
        }
    }
}
