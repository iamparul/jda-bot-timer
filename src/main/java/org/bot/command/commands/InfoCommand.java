package org.bot.command.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bot.command.CommandContext;
import org.bot.command.ICommand;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.List;

public class InfoCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Info");
        embedBuilder.addField("🤔","info",false);
        embedBuilder.addField("Crypto info","info",false);
        embedBuilder.setColor(Color.BLUE);
        channel.sendMessage(embedBuilder.build()).queue();
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getHelp() {
        return "info help";
    }
}
