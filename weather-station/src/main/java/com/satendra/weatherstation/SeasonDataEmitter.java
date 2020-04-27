package com.satendra.weatherstation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Slf4j
@RequiredArgsConstructor
public class SeasonDataEmitter {

    final List<SeasonType> seasonData = Collections.unmodifiableList(Arrays.asList(SeasonType.values()));

    final Random random = new Random();


    final private SeasonSender seasonSender;

    /**
     * Method that emit event in random interval;
     */
    @Scheduled(fixedRate = 5000, initialDelay = 10000)
    public void emmitData() {
        try {
            //log.info("Event emitted @ " + LocalDateTime.now());
            SeasonData seasonData = createSeasonData();
            seasonSender.sendSeason(seasonData);
            log.info("Event emitted @ "  + seasonData.getSeasonType());
            //System.out.println(seasonData.getSeasonType().toString());
            int randomSleepTime = ThreadLocalRandom.current().nextInt(20000);
            Thread.sleep(randomSleepTime);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    public SeasonType getRandomSeason() {
        SeasonType randomSeasonName = seasonData.get(random.nextInt(seasonData.size()));
        return randomSeasonName;
    }

    public SeasonData createSeasonData() {
        SeasonData seasonData = new SeasonData();
        //seasonData.setLocalDateTime(LocalDateTime.now());
        seasonData.setSeasonType(getRandomSeason());
        return seasonData;
    }
}
