package com.example.testedtilistadelembretes.dto;

import com.example.testedtilistadelembretes.entity.Lembrete;

import java.time.LocalDate;

public record LembreteResponseDTO(Long id, String name, LocalDate date, String description) {

    public LembreteResponseDTO(Lembrete lembrete) {
        this(lembrete.getId(), lembrete.getName(), lembrete.getDate(), lembrete.getDescription());
    }
}