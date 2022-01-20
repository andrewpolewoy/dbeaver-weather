package com.dbeaver.weather.service.api;

import com.dbeaver.weather.model.Weather;

import java.time.LocalDate;

public interface IWeatherService {
    Weather getWeatherByDate(LocalDate aLong);
    void save(Weather weather);
}
