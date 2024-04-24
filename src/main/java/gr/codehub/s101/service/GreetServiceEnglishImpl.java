package gr.codehub.s101.service;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
@Primary
@NoArgsConstructor
public class GreetServiceEnglishImpl implements GreetService{
    private static final String NEW_LINE = "<br/>";

    public String greetWithInfo(String name) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E dd/MM/YYYY HH:mm:ss");
        String text = "Hello " + name + NEW_LINE;
        text += "The date is " + LocalDateTime.now().format(formatter) + NEW_LINE;
        text += "Your lucky number is " + (int)(Math.random() * 6 + 1);
        return text;
    }
}
