package com.dbeaver.weather.controller.rest;

import com.dbeaver.weather.model.Weather;
import com.dbeaver.weather.service.HttpClient;
import com.dbeaver.weather.service.api.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;

@RestController
@RequestMapping("/weather")
public class WeatherControllerRest {

    @Autowired
    private final IWeatherService service;
    @Autowired
    private final HttpClient client;

    public WeatherControllerRest(IWeatherService service, HttpClient client) {
        this.service = service;
        this.client = client;
    }

    @GetMapping
    public ResponseEntity<Weather> getActualWeather() {
        Weather weather = service.getWeatherByDate(LocalDate.now());
        if (weather != null) {
            return new ResponseEntity<>(weather, HttpStatus.OK);
        } else {
            Weather weather1 = client.readWeatherInfo();
            service.save(weather1);
            return new ResponseEntity<>(weather1, HttpStatus.ACCEPTED);
        }
    }
}