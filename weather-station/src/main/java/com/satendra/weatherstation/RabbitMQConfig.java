package com.satendra.weatherstation;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String SUB_STATION_1_NOTIFICATION_QUEUE = "sub-station-1-notification-queue";
    public static final String SUB_STATION_2_NOTIFICATION_QUEUE = "sub-station-2-notification-queue";

    public static final String WEATHER_NOTIFICATION_EXCHANGE = "weather-notification-exchange";

    @Bean("subStation1Queue")
    Queue subStation1Queue() {
        return QueueBuilder.durable(SUB_STATION_1_NOTIFICATION_QUEUE).build();
    }

    @Bean("subStation2Queue")
    Queue subStation2Queue() {
        return QueueBuilder.durable(SUB_STATION_2_NOTIFICATION_QUEUE).build();
    }

    @Bean
    Exchange weatherNotificationExchange() {
        return ExchangeBuilder.fanoutExchange(WEATHER_NOTIFICATION_EXCHANGE).build();
    }

    @Bean
    Binding binding1Q(@Qualifier("subStation1Queue") Queue queue1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue1).to(fanoutExchange);
    }

    @Bean
    Binding binding2Q(@Qualifier("subStation2Queue") Queue queue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue2).to(fanoutExchange);
    }


    // configuration: to convert set message to json
    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
