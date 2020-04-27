package com.satendra.weathersubstation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WeatherListener {


    @RabbitListener(queues = RabbitMQConfig.SUB_STATION_1_NOTIFICATION_QUEUE)
    public void processNotification(SeasonData seasonData) {
        log.info("Weather received  sub-station 1 @ "  + seasonData.getSeasonType());

    }

}
