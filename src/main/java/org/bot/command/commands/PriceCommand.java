package org.bot.command.commands;

import net.dv8tion.jda.api.entities.TextChannel;
import org.bot.CommandManager;
import org.bot.CryptoRequest;
import org.bot.command.CommandContext;
import org.bot.command.ICommand;
import org.bot.dto.Bitcoin;
import org.bot.dto.PriceDTO;

import java.util.List;

public class PriceCommand implements ICommand {

    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();
        System.out.println(args);
        try {
            PriceDTO dto = CryptoRequest.getCoinPrice(args.get(0),args.get(1));
            Bitcoin bitcoin = dto.getBitcoin();
            int coinPrice = bitcoin.getInr();
            channel.sendMessage(args.get(0) + " price in " + args.get(1) + " is " + coinPrice).queue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "price";
    }

    @Override
    public String getHelp() {
        return "Get the price of any Crypto Coins!!";
    }
}
