package com.example.testedtilistadelembretes.controller;

import com.example.testedtilistadelembretes.dto.LembreteRequestDTO;
import com.example.testedtilistadelembretes.dto.LembreteResponseDTO;
import com.example.testedtilistadelembretes.entity.Lembrete;
import com.example.testedtilistadelembretes.repository.LembreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lembrete")
public class LembreteController {

    @Autowired
    private LembreteRepository lembreteRepository;

    // Método para listar todos os lembretes
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<LembreteResponseDTO> listarLembretes() {
        List<LembreteResponseDTO> lembreteList = lembreteRepository.findAll()
                .stream()
                .map(LembreteResponseDTO::new)
                .collect(Collectors.toList());
        return lembreteList;
    }

    // Método para criar um novo lembrete
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<Lembrete> criarLembrete(@RequestBody LembreteRequestDTO data) {
        Lembrete lembreteData = new Lembrete(data);
        Lembrete lembreteSalvo = lembreteRepository.save(lembreteData);
        return ResponseEntity.status(HttpStatus.CREATED).body(lembreteSalvo);
    }

    // Método para deletar um lembrete pelo ID
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLembrete(@PathVariable Long id) {
        Optional<Lembrete> lembreteOptional = lembreteRepository.findById(id);
        if (lembreteOptional.isPresent()) {
            lembreteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
