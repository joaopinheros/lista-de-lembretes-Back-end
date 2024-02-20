package com.example.testedtilistadelembretes.dto;

import com.example.testedtilistadelembretes.entity.Lembrete;

import java.time.LocalDate;

public record LembreteRequestDTO(String name, LocalDate date, String description) {

}
