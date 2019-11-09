package com.HIT.software;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

@Controller
public class EventController {
    private EventRepository eventRepository;
    private String date;
    private String start_date = "2018-07-04 00:00:00";
    private List<Event> today;

    @Autowired
    public EventController(EventRepository eventRepository){
        init_today();
        this.eventRepository=eventRepository;
    }

    public void init_today(){
        List<Event> all= eventRepository.findAll();
        for(Event event : all){
            if (event.getCreatetime().substring(0, 10).equals("2018-10-30")){
                today.add(event);
            }
        }
        return;
    }

    public ArrayList<String> Handle(List<Event> list){
        ArrayList<String> ans = new ArrayList<>();
        String data;
        int ganxie = 0, jianyi = 0, qiujue = 0, tousu = 0, zixun = 0, qita = 0;
        for (Event event : list){
            if (event.getEVENT_PROPERTY_NAME().equals("感谢")){
                ganxie += 1;
            }
            else if (event.getEVENT_PROPERTY_NAME().equals("建议")){
                jianyi += 1;
            }
            else if (event.getEVENT_PROPERTY_NAME().equals("求决")){
                qiujue += 1;
            }
            else if (event.getEVENT_PROPERTY_NAME().equals("投诉")){
                tousu += 1;
            }
            else if (event.getEVENT_PROPERTY_NAME().equals("咨询")){
                zixun += 1;
            }
            else{
                qita += 1;
            }

        }
        ans.add("{");
        data = ("value: " + Integer.toString(ganxie) + ", name:感谢");
        ans.add(data);
        data = ("value: " + Integer.toString(jianyi) + ", name:建议");
        ans.add(data);
        data = ("value: " + Integer.toString(qiujue) + ", name:求决");
        ans.add(data);
        data = ("value: " + Integer.toString(tousu) + ", name:投诉");
        ans.add(data);
        data = ("value: " + Integer.toString(zixun) + ", name:咨询");
        ans.add(data);
        data = ("value: " + Integer.toString(qita) + ", name:其他");
        ans.add(data);
        ans.add("}");
        return ans;
    }

    @GetMapping("/page1")
    public String page1(){
        return "page1";
    }

    @GetMapping("/page2")
    public String page2(){
        return "page2";
    }

    @PostMapping("/page1")
    public String getDate(String year_1, String month_1, String day_1){
        date = (year_1 + "-" + month_1 + "-" + day_1 + " 23:59:59");
        System.out.println(date);
        return "redirect:/hello";
    }

    @GetMapping("/hello")
    @ResponseBody
    public ArrayList<String> findByDate(HttpServletRequest request, HttpServletResponse response) {
        List<Event> events = eventRepository.findAll();
        List<Event> eventList = new ArrayList<>();
        ArrayList<String> json = new ArrayList<>();
        for (Event event : events){
            String create_date = event.getCreatetime();
//            System.out.println(create_date);
            if ((create_date.compareTo(start_date)>=0) && (create_date.compareTo(date)<=0)){
                eventList.add(event);
            }
        }
        if (eventList.isEmpty())
        {
            if(null != today)
                json = Handle(today);
            else
                json = null;
        }
        else{
            json = Handle(eventList);
        }
        System.out.println(json);
        return json;
    }
}
