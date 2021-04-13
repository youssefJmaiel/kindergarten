package com.kindergarten.springbootcrud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="event_tbl")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name="date_debut")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateDebut;
    @Column(name="date_fin")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateFin;
    private String activity;
    private String description;
    private String kindergartenId;
    private String adresse;

}
