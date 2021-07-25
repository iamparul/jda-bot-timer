package org.bot.dto;

import java.util.List;

public class TrendingCoinDTO {
    public List<Coin> coins;
    public List<Object> exchanges;

    public TrendingCoinDTO() {
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public List<Object> getExchanges() {
        return exchanges;
    }

    public void setExchanges(List<Object> exchanges) {
        this.exchanges = exchanges;
    }
}
