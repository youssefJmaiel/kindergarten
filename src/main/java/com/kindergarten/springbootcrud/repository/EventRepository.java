package com.kindergarten.springbootcrud.repository;

import com.kindergarten.springbootcrud.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface EventRepository extends JpaRepository<Event,Integer> {
    Event findByName(String name);



    @Query("select e from Event e " + "where e.dateDebut = :date  order by e.dateDebut desc ")
    List<Event> findByDate_debut(@Param("date") LocalDateTime date);


    @Query("select e from Event e " + "where e.dateFin = :date  order by e.dateFin desc ")
    List<Event> findByDate_Fin(@Param("date") LocalDateTime date);


   // List<Event> findAllByDateDebutLessThanEqualAndDateFinGreaterThanEqual(LocalDate startDate, LocalDate endDate);

    List<Event> findAllByDateDebutIsBetween(LocalDateTime startDate, LocalDateTime endDate);



    int countAllByKindergartenId(String id);
    List<Event> findAllByKindergartenId(String id);
}
