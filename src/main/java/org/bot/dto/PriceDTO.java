package org.bot.dto;

public class PriceDTO {
    public Bitcoin getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(Bitcoin bitcoin) {
        this.bitcoin = bitcoin;
    }

    public PriceDTO() {
    }

    public Bitcoin bitcoin;
}

