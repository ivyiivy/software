package com.HIT.software;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EventController {
    private EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository){
        this.eventRepository=eventRepository;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String Hello(){
        List<Event> events =eventRepository.findAll();
        String street=events.get(1).getSTREET_NAME();
        return street;
    }
}
