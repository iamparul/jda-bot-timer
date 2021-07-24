package org.bot;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Main {
    public static JDA jda;
    public static String prefix=PropertyReader.getInstance().getProperty("prefix");
    public static String TOKEN=PropertyReader.getInstance().getProperty("token");

    public static void main(String[] args) throws LoginException {
        jda = JDABuilder.createDefault(TOKEN).build();
        jda.addEventListener(new Listener());
    }
}
