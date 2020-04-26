package com.satendra.weathersubsation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WeatherListener {


    @RabbitListener(queues = RabbitMQConfig.SUB_STATION_2_NOTIFICATION_QUEUE)
    public void processNotification(SeasonData seasonData) throws JsonProcessingException {

        log.info("Weather received  sub-station 2 @ "  + seasonData.getSeasonType());

    }

}
