package com.satendra.weatherstation;

import lombok.Data;
import org.springframework.amqp.core.MessageBuilder;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class SeasonData implements Serializable {

    //private LocalDateTime localDateTime;

    private SeasonType seasonType;
}
