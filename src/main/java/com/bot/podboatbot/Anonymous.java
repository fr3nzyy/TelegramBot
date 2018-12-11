package com.bot.podboatbot;

/**
 * Created by fr3nzy on 11.12.2018.
 */
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

public final class Anonymous {

    private final User mUser;
    private final Chat mChat;
    private String mDisplayedName;

    public Anonymous(User user, Chat chat) {
        mUser = user;
        mChat = chat;
    }

    @Override
    public int hashCode() {
        return mUser.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Anonymous && ((Anonymous) obj).getUser().equals(mUser);
    }

    public User getUser() {
        return mUser;
    }

    public Chat getChat() {
        return mChat;
    }

    public String getDisplayedName() {
        return mDisplayedName;
    }

    public void setDisplayedName(String displayedName) {
        mDisplayedName = displayedName;
    }
}