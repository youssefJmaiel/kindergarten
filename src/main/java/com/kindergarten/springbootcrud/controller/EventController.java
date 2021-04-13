package com.kindergarten.springbootcrud.controller;

import com.kindergarten.springbootcrud.entity.Event;
import com.kindergarten.springbootcrud.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventService service;
    @PostMapping("/addEvent")
    public Event addEvent(@RequestBody Event event){
        return service.saveEvent(event);

    }
    @PostMapping("/addEvents")
    public List<Event> addEvents(@RequestBody List<Event> events){
        return service.saveEvents(events);
    }
    @GetMapping("/events")
    public List<Event> findAllEvents(){
        return service.getEvents();
    }
    @GetMapping("/getevent/{id}")
    public Event findEventById(@PathVariable int id){
        return service.getEventById(id);
    }
    @GetMapping("/event/{name}")
    public Event findEventByName(@PathVariable String name){
        return service.getEventByName(name);
    }
    @GetMapping("/eventbydatedeb/{date}")
    public List<Event> findAllEventsByDateDeb(@PathVariable String date) throws ParseException {
        return service.findEventsByStartDate(date);
    }

    @GetMapping("/eventbydateFin/{date}")
    public List<Event> findAllEventsByDateFin(@PathVariable String date) throws ParseException {
        return service.findEventsByEndDate(date);
    }

    @GetMapping("/eventbetween/{date1}/{date2}")
    public List<Event> findAllEventsBetween(@PathVariable String date1,@PathVariable String date2) throws ParseException {
        return service.findEventsBetween(date1, date2);
    }
    @GetMapping("/kindergartNbenevents/{id}")
    public int getNbrEvents(@PathVariable String id){
        return service.nbrEventsByKindergarten(id);
    }
    @GetMapping("/kindergarteneventList/{id}")
    public List<Event> getKindergartenEventList(@PathVariable String id){
        return service.listKindergatenEvents(id);
    }

    @PutMapping("/eventupdate")
    public Event updateEvent(@RequestBody Event event){
        return service.updateEvent(event);

    }
    @DeleteMapping("/deleteEvent/{id}")
    public String deleteEvent(@PathVariable int id){
        return service.deleteEvent(id);
    }
}
