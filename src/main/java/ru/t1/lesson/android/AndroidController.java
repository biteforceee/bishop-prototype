package ru.t1.lesson.android;

import org.springframework.web.bind.annotation.*;
import ru.t1.lesson.audit.WeylandWatchingYou;
import ru.t1.lesson.command.Command;
import ru.t1.lesson.command.CommandQueueService;

@RestController
@RequestMapping("/command")
public class AndroidController {
    private CommandQueueService commandQueueService;

    public AndroidController(CommandQueueService commandQueueService) {
        this.commandQueueService = commandQueueService;
    }

    @WeylandWatchingYou
    @PostMapping
    public void addCommand(@RequestBody Command command) throws InterruptedException {
        commandQueueService.submit(command);
    }

    @GetMapping("/count")
    public long getCompletedCommandCount(@RequestBody String author){
        return commandQueueService.getCommandCount(author);
    }

    @GetMapping("/queue-size")
    public int getQueueSize() {
        return (int) commandQueueService.getQueueSize();
    }
}
