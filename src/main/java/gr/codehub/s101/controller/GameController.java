package gr.codehub.s101.controller;

import gr.codehub.s101.service.GameResultsService;
import gr.codehub.s101.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameResultsService gameResultsService;

    @GetMapping("/play/{choice}")
    public String play(@PathVariable String choice) {
        boolean win = gameService.playOddEven(choice);
        String html = gameResultsService.getResultsHtml(choice, win);
        return html;
    }
}
