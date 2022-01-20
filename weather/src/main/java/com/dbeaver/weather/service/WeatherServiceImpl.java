package com.dbeaver.weather.service;

import com.dbeaver.weather.model.Weather;
import com.dbeaver.weather.service.api.IWeatherService;
import com.dbeaver.weather.repository.api.IWeatherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Slf4j
@Service
public class WeatherServiceImpl implements IWeatherService {

    @Autowired
    private IWeatherRepository repository;

    public WeatherServiceImpl(IWeatherRepository repository) {
        this.repository = repository;
    }

    @Override
    public Weather getWeatherByDate(LocalDate date) {
        log.info("IN WeatherServiceImpl getWeatherByDate {}", date);
        return repository.findByDate(date);
    }

    @Override
    public void save(Weather weather) {
        log.info("IN WeatherServiceImpl save {}", weather);
        repository.saveAndFlush(weather);
    }
}
