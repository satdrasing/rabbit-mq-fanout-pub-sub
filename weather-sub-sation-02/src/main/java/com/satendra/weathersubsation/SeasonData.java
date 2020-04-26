package com.satendra.weathersubsation;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SeasonData implements Serializable {

    //private LocalDateTime localDateTime;

    private SeasonType seasonType;



}
