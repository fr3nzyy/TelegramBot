package com.bot.podboatbot;

/**
 * Created by fr3nzy on 11.12.2018.
 */
import org.telegram.telegrambots.extensions.bots.commandbot.commands.ICommandRegistry;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public final class HelpCommand extends AnonymizerCommand {

    private final ICommandRegistry mCommandRegistry;

    public HelpCommand(ICommandRegistry commandRegistry) {
        super("help", "list all known commands\n");
        mCommandRegistry = commandRegistry;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

        log.info(user.getId() + " " + getCommandIdentifier());

        StringBuilder helpMessageBuilder = new StringBuilder("&lt;b&gt;Available commands:&lt;/b&gt;\n\n");

        mCommandRegistry.getRegisteredCommands().forEach(cmd -> helpMessageBuilder.append(cmd.toString()).append("\n"));

        SendMessage helpMessage = new SendMessage();
        helpMessage.setChatId(chat.getId().toString());
        helpMessage.enableHtml(true);
        helpMessage.setText(helpMessageBuilder.toString());

        execute(absSender, helpMessage, user);
    }
}