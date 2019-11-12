package com.HIT.software;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.script.ScriptTemplateConfig;

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
    private String end_date = "2018-10-30 23:59:59";
    private List<Event> today = new ArrayList<>();


    public void init_today(){
        List<Event> all= eventRepository.findAll();
        if (!all.isEmpty()){
            for(Event event : all){
                if (!event.getCreatetime().isBlank()){
                    if (event.getCreatetime().substring(0, 10).equals("2018-10-30")){
                        today.add(event);
                    }
                }
            }
        }
        return;
    }

    public EventProperty Handle(List<Event> list) throws JsonProcessingException {
        EventProperty data = new EventProperty();
        int ganxie = 0, jianyi = 0, qiujue = 0, tousu = 0, zixun = 0, qita = 0;
        for (Event event : list){
            if (event.getEventpropertyname().equals("感谢")){
                ganxie += 1;
            }
            else if (event.getEventpropertyname().equals("建议")){
                jianyi += 1;
            }
            else if (event.getEventpropertyname().equals("求决")){
                qiujue += 1;
            }
            else if (event.getEventpropertyname().equals("投诉")){
                tousu += 1;
            }
            else if (event.getEventpropertyname().equals("咨询")){
                zixun += 1;
            }
            else if (event.getEventpropertyname().equals("其他")){
                qita += 1;
            }

        }
<<<<<<< HEAD
        data = ("{value: " + ganxie + ", name:感谢}");
        ans.add(data);

        data = ("{value: " + jianyi + ", name:建议}");
        ans.add(data);

        data = ("{value: " + qiujue + ", name:求决}");
        ans.add(data);

        data = ("{value: " + tousu + ", name:投诉}");
        ans.add(data);

        data = ("{value: " + zixun + ", name:咨询}");
        ans.add(data);

        data = ("{value: " + qita + ", name:其他}");
        ans.add(data);

        return ans;
=======
        data.setGanxie(ganxie);
        data.setJianyi(jianyi);
        data.setQita(qita);
        data.setQiujue(qiujue);
        data.setTousu(tousu);
        data.setZixun(zixun);
        return data;
>>>>>>> lianghanzhao
    }

    @Autowired
    public EventController(EventRepository eventRepository){
        this.eventRepository=eventRepository;
    }

    @GetMapping("/page1")
    public String page1(){
        return "page1";
    }

    @GetMapping("/page2")
    public String page2(){
        return "page2";
    }

//    @GetMapping("/caonima")
//    public String caonima(){
//        return "caonima";
//    }

    @PostMapping("/page1")

<<<<<<< HEAD
    @GetMapping("/page1")
    @ResponseBody
    public ArrayList<String> findByDate() throws JsonProcessingException {
=======
    public String getDate(String year_1, String month_1, String day_1,Model model) throws JsonProcessingException {
        date = (year_1 + "-" + month_1 + "-" + day_1 + " 23:59:59");
//        System.out.println(date);
>>>>>>> lianghanzhao
        init_today();
        ObjectMapper mapper = new ObjectMapper();
        EventProperty eventProperty = new EventProperty();
        List<Event> events = eventRepository.findAll();
        List<Event> eventList = new ArrayList<>();
        String jsondata;
        for (Event event : events){
            String create_date = event.getCreatetime();
//            System.out.println(create_date);
            if ((create_date.compareTo(start_date)>=0) && (create_date.compareTo(date)<=0) && (create_date.compareTo(end_date)<=0)){
                eventList.add(event);
            }
        }
//        for (Event event : eventList){
//            String str = event.getCreatetime();
//            System.out.println(str);
//        }
        if (eventList.isEmpty())
        {
<<<<<<< HEAD
            if(!today.isEmpty())
                json = Handle(today);
=======
            if(null != today){
                eventProperty = Handle(today);
                jsondata = mapper.writeValueAsString(eventProperty);
            }
>>>>>>> lianghanzhao
            else
                jsondata = null;
        }
        else{
            eventProperty = Handle(eventList);
            jsondata = mapper.writeValueAsString(eventProperty);
        }
<<<<<<< HEAD

//        writeJsonToResponseByGson(json, response);
        return json;
=======
//        writeJsonToResponseByGson(json, response);\\

        model.addAttribute("data", jsondata);
        //return jsondata;
        return "page1";
>>>>>>> lianghanzhao
    }

}
