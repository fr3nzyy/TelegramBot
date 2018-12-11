package com.bot.podboatbot;

/**
 * Created by fr3nzy on 11.12.2018.
 */
//import io.example.anonymizerbot.logger.LogLevel;
//import io.example.anonymizerbot.logger.LogTemplate;
//import org.apache.logging.log4j.Level;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

abstract class AnonymizerCommand extends BotCommand {

    final Logger log = LogManager.getLogger(getClass());

    AnonymizerCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    void execute(AbsSender sender, SendMessage message, User user) {
        try {
            sender.execute(message);
            log.log(Priority.INFO, user.getId() + " " + getCommandIdentifier());
        } catch (TelegramApiException e) {
            log.error(user.getId() + " " + getCommandIdentifier(), e);
        }
    }
}