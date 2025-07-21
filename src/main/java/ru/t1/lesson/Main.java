package ru.t1.lesson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.t1.lesson.command.Command;
import ru.t1.lesson.command.CommandPriority;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Command cmd = new Command("qwe"
        , CommandPriority.CRITICAL
        ,"asd"
        ,"2023-07-21T12:30:45.000Z");
        System.out.println(objectMapper.writeValueAsString(cmd));
        SpringApplication.run(Main.class);
    }
}