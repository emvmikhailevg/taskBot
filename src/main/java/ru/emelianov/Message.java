package ru.emelianov;

/**
 * Сообщение
 *
 * @param chatId id чата
 * @param text сообщение
 *
 * @author mikhailemv
 * @since 09.11.2023
 */
public record Message(long chatId, String text) {}
