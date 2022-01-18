package com.dbeaver.weather.repository.api;

import com.dbeaver.weather.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;


public interface IWeatherRepository extends JpaRepository<Weather,Long> {

    @Query("SELECT u FROM Weather u WHERE u.date=?1")
    Weather findByDate(LocalDate date);
}
