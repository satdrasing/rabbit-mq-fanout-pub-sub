package com.satendra.weathersubstation;

import lombok.Data;

import java.io.Serializable;

@Data
public class SeasonData implements Serializable {

    //private LocalDateTime localDateTime;

    private SeasonType seasonType;



}
