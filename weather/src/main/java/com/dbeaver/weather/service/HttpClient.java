package com.dbeaver.weather.service;

import com.dbeaver.weather.model.Weather;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Iterator;

@Service
public class HttpClient {

    private static final String OPEN_WEATHER_MAP_API = "https://api.weather.yandex.ru/v2/forecast?";
    private static final String WEATHER_MAP_LAT = "59.938951";
    private static final String WEATHER_MAP_LON = "30.315635";
    private static final String WEATHER_MAP_KEY = "e3ebb0de-6c1f-4b52-8e8a-763fb902fd67";


    public HttpClient() {
    }

    public Weather readWeatherInfo() {

        try {
            URL url = new URL(OPEN_WEATHER_MAP_API + "lat=" + WEATHER_MAP_LAT + "&lon=" + WEATHER_MAP_LON);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.addRequestProperty("X-Yandex-API-Key", WEATHER_MAP_KEY);
            connection.connect();

            InputStream in;
            int status = connection.getResponseCode();
            if (status != HttpURLConnection.HTTP_OK) {
                in = connection.getErrorStream();
            } else {
                in = connection.getInputStream();
            }

            String response = convertStreamToString(in);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(response);

            for (Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext(); ) {
                String key = (String) iterator.next();
                if (key.equals("fact")) {
                    JSONObject o = (JSONObject) jsonObject.get(key);
                    String s = o.get("temp").toString();
                    Weather weather = new Weather();
                    weather.setValue(s);
                    weather.setDate(LocalDate.now());
                    return weather;
                } else {
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("");
            return null;
        }
        return null;
    }


    private String convertStreamToString(InputStream stream) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        stream.close();
        return sb.toString();
    }

}