package gr.codehub.s101.service.impl;

import gr.codehub.s101.service.GameService;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class GameServiceImpl implements GameService {

    @Override
    public boolean playOddEven(String choice) {
        boolean odd = Math.random() < 0.5;
        boolean win = (odd && choice.equals("odd")) || (!odd && choice.equals("even"));
        return win;
    }
}
