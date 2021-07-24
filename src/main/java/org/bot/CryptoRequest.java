package org.bot;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CryptoRequest {

    private static URL url;

    public CryptoRequest(URL url) {
        this.url = url;
    }

    public static String getCoinPrice(String ids, String currency) {
        String inr = "";
        try {
            String readLine = null;
            url = new URL("https://api.coingecko.com/api/v3/simple/price?ids="+ids + "&vs_currencies=" + currency);
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
                in.close();
                JSONObject jsonObject = new JSONObject(response.toString());
                System.out.println("JSON String Result " + response.toString());
                inr = jsonObject.getJSONObject(ids).get(currency).toString();
            } else {
                System.out.println("GET NOT WORKED");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return inr;
    }
}