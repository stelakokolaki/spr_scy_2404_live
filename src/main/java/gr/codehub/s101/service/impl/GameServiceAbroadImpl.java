package gr.codehub.s101.service.impl;

import gr.codehub.s101.service.GameService;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Profile("play-abroad")
public class GameServiceAbroadImpl implements GameService {
    Logger logger = LoggerFactory.getLogger(GameServiceAbroadImpl.class);

    @Override
    public boolean playOddEven(String choice) {
        logger.info("Called abroad implementation");
        boolean houseAdvantage = Math.random() < 0.1;
        if (houseAdvantage) {
            logger.info("House won on house advatage");
            return false;
        }
        boolean odd = Math.random() < 0.5;
        boolean win = (odd && choice.equals("odd")) || (!odd && choice.equals("even"));
        return win;
    }
}
