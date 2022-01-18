package com.dbeaver.weather.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.it_academy.jd2.config")
public class RootConfig {


//    @Bean
//    public IWeatherService userView(IWeatherRepository repository) {
//        return new WeatherServiceImpl(repository);
//    }
}
