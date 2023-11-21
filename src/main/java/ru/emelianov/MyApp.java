package ru.emelianov;

/**
 * Применить ниспадающее программирование для задачи построения архитектуры чат-бот платформы.
 * Построить базовую архитектуру бота, который сможет работать в  telegram и ещё как минимум одной чат-бот платформе (Discord, VK или др.). В качестве основного функционала бота можно возвращать в ответ текст, который отправил пользователь с пометкой от бота. Например "Ваше сообщение: <сообщение>". Нужно акцентировать внимание именно на архитектуре и интерфейсах.
 * Пример:
 * User: привет
 * Bot: "Ваше сообщение: 'привет'"..
 *
 * @author mikhailemv
 * @since 09.11.2023
 */
public class MyApp {

    public static void main( String[] args )
    {
        new MyTelegramBot().register(System.getProperty("telegramToken"));
        new MyDiscordBot().register(System.getProperty("discordToken"));
    }
}
