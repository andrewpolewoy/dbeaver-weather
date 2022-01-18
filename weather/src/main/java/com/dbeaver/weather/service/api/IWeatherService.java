package com.dbeaver.weather.service.api;

import com.dbeaver.weather.model.Weather;

import java.time.LocalDate;

public interface IWeatherService {
    Weather getWeatherByDate(LocalDate aLong);
//    Weather readWeatherInfo();
    void save(Weather weather);
}
