package com.kindergarten.springbootcrud.service;
import com.kindergarten.springbootcrud.entity.Event;
import com.kindergarten.springbootcrud.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class EventService {
    @Autowired
    private EventRepository repository;

    public Event saveEvent(Event event){
        return   repository.save(event);
    }
    public List<Event> saveEvents(List<Event> events){
        return   repository.saveAll(events);
    }
    public List<Event> getEvents(){
        return repository.findAll();
    }
    public Event getEventById(int id){
        return repository.findById(id).orElse(null);
    }
    public Event getEventByName(String name){
        return repository.findByName(name);
    }
    public String deleteEvent(int id){
        repository.deleteById(id);
        return "event removed !!"+id;
    }
    public Event updateEvent(Event event){
        Event existingEvent=repository.findById(event.getId()).orElse(null);
        existingEvent.setName(event.getName());
        existingEvent.setDateDebut(event.getDateDebut());
        existingEvent.setDateFin(event.getDateFin());
        existingEvent.setActivity(event.getActivity());
        existingEvent.setDescription(event.getDescription());
        existingEvent.setKindergartenId(event.getKindergartenId());
        return repository.save(existingEvent);

    }
    public List<Event> findEventsByStartDate(String date_deb)  {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        //convert String to LocalDate
        LocalDateTime localDate = LocalDateTime.parse(date_deb, formatter);

        return  repository.findByDate_debut(localDate);
    }

    public List<Event> findEventsByEndDate(String date)  {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        //convert String to LocalDate
        LocalDateTime localDate = LocalDateTime.parse(date, formatter);

        return  repository.findByDate_Fin(localDate);

    }

    public List<Event> findEventsBetween(String date1, String date2)  {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        //convert String to LocalDate
        LocalDateTime localDate1 = LocalDateTime.parse(date1, formatter);
        LocalDateTime localDate2 = LocalDateTime.parse(date2, formatter);

        return  repository.findAllByDateDebutIsBetween(localDate1,localDate2);
    }
    public int nbrEventsByKindergarten(String id){
        return  repository.countAllByKindergartenId(id);
    }
    public List<Event> listKindergatenEvents(String id){
        return repository.findAllByKindergartenId(id);
    }


}
