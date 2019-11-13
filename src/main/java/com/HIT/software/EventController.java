package com.HIT.software;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

@Controller
@RequestMapping("/hello")
public class EventController {
    private EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository){
        this.eventRepository=eventRepository;
    }
    @GetMapping("")
    @ResponseBody
    public String Hello() throws JsonProcessingException {
        String hello="hello";
        return hello;

    }
    @RequestMapping("/json")
    @ResponseBody
    public String Json() throws JsonProcessingException {
        List<Event> events =eventRepository.findAll();

        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(events);
        return json;

    }

}
