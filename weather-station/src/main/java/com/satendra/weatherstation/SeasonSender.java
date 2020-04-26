package com.satendra.weatherstation;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeasonSender {

    private final RabbitTemplate rabbitTemplate;

    public void sendSeason(SeasonData seasonData) {
        this.rabbitTemplate.convertAndSend(RabbitMQConfig.WEATHER_NOTIFICATION_EXCHANGE,"", seasonData);

    }
}
