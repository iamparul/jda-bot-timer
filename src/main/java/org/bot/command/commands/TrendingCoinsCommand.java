package org.bot.command.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bot.CryptoRequest;
import org.bot.TrendingCoinsRequest;
import org.bot.command.CommandContext;
import org.bot.command.ICommand;
import org.bot.dto.*;

import java.util.List;

public class TrendingCoinsCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("Top - 7 Trending Crypto Coins!!");
//        builder.setTitle(/ )
        System.out.println(args);
        try {
            TrendingCoinDTO dto = TrendingCoinsRequest.getTrendingCoins();
            List<Coin> coins = dto.getCoins();
            PriceDTO pricedto = CryptoRequest.getCoinPrice("bitcoin", "inr");
            Bitcoin bitcoin = pricedto.getBitcoin();
            int coinPrice = bitcoin.getInr();
            for (Coin c : coins) {
                Item item = c.getItem();
                builder.addField(item.name, String.valueOf(item.price_btc * coinPrice), true);
            }
            builder.setFooter("Values are in INR only");
            channel.sendMessage(builder.build()).queue();
//            channel.sendMessage(args.get(0) + " price in " + args.get(1) + " is " + coinPrice).queue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "trending";
    }

    @Override
    public String getHelp() {
        return "Top-7 trending coins on CoinGecko as searched by users in the last 24 hours (Ordered by most popular first)";
    }
}
