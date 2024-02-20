package com.example.testedtilistadelembretes.entity;

import com.example.testedtilistadelembretes.dto.LembreteRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity(name = "lembrete")
@Table(name = "lembrete")
public class Lembrete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",nullable = false, length = 100)
    private String name;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Column(name = "description", length = 255)
    private String description;

    //Construtor para o DTO
    public Lembrete(LembreteRequestDTO data){
        this.name = data.name();
        this.date = data.date();
        this.description = data.description();
    }
}
