package gr.codehub.s101.service.impl;

import gr.codehub.s101.service.GameResultsService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class GameResultsServiceImpl implements GameResultsService {
    private final static String BR = "<br/>";

    @Override
    public String getResultsHtml(String choice, boolean win) {
        String html = "";
        html += "It is " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")) + BR + BR;
        html += "You chose " + choice + BR + BR;
        html += (win? "You won!" : "You lost!") + BR + BR;
        html += "Play again:" + BR ;
        html += localLink("odd", "/play/odd") + " " + localLink("even", "/play/even");
        return html;
    }

    private String localLink(String text, String endPoint) {
        return "<a href=\"http://localhost:8080"+ endPoint + "\">" + text + "</a>";
    }

}
