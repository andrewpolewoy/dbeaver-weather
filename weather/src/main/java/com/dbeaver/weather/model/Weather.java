package com.dbeaver.weather.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@ToString
@JsonIgnoreProperties(value = { "id","date" })
@Table(name = "weather_history", schema = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name = "weather_date")
    private LocalDate date;

    @JsonProperty("actual_temp")
    @Column(name = "weather_value")
    private String value;

}
