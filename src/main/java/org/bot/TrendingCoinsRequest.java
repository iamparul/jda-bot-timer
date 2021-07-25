package org.bot;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bot.dto.Coin;
import org.bot.dto.Item;
import org.bot.dto.TrendingCoinDTO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Set;

public class TrendingCoinsRequest {

    private static URL url;

    public TrendingCoinsRequest(URL url) {
        this.url = url;
    }

    public static TrendingCoinDTO getTrendingCoins() throws IOException {
        String readLine = null;
        url = new URL("https://api.coingecko.com/api/v3/search/trending");
        HttpURLConnection conection = (HttpURLConnection) url.openConnection();
        conection.setRequestMethod("GET");
        int responseCode = conection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            System.out.println(response);
            ObjectMapper objectMapper = new ObjectMapper();
            TrendingCoinDTO dto = objectMapper.readValue(response.toString(),TrendingCoinDTO.class);
            return dto;
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        getTrendingCoins();
    }
}