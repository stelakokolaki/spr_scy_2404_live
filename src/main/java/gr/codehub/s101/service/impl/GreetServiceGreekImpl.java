package gr.codehub.s101.service.impl;

import gr.codehub.s101.service.GreetService;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
@NoArgsConstructor
public class GreetServiceGreekImpl implements GreetService {
    private static final String NEW_LINE = "<br/>";

    public String greetWithInfo(String name) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E dd/MM/YYYY HH:mm:ss");
        String text = "Γειά σου " + name + NEW_LINE;
        text += "Σήμερα είναι " + LocalDateTime.now().format(formatter) + NEW_LINE;
        text += "Ο τυχερός σου αριθμός είναι το " + (int)(Math.random() * 6 + 1);
        return text;
    }
}
