package org.bot.command.commands;

import net.dv8tion.jda.api.entities.TextChannel;
import org.bot.CommandManager;
import org.bot.PropertyReader;
import org.bot.command.CommandContext;
import org.bot.command.ICommand;

import java.util.List;

public class HelpCommand implements ICommand {

    private final CommandManager manager;

    public HelpCommand(CommandManager manager) {
        this.manager = manager;
    }

    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();

        if (args.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            builder.append("List of commands\n");
            manager.getCommands().stream().map(ICommand::getName).forEach(
                    (it) -> builder.append('`').append(PropertyReader.getInstance()
                            .getProperty("prefix")).append(it).append("`\n")
            );

            channel.sendMessage(builder.toString()).queue();
            return;
        }

        String search = args.get(0);
        ICommand command = manager.getCommand(search);

        if (command == null) {
            channel.sendMessage("Nothing found for " + search).queue();
            return;
        }
        channel.sendMessage(command.getHelp()).queue();
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getHelp() {
        return "Shows the list with commands in the bot\n" +
                "Usage : `~help [command]`";
    }
}
