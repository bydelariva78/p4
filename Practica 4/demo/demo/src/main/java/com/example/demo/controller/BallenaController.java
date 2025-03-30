package com.example.demo.controller;

import com.example.demo.modelo.Ballena;
import com.example.demo.service.BallenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ballenas")
public class BallenaController {

    @Autowired
    private BallenaService ballenaService;

    // Obtener todas las ballenas
    @GetMapping
    public List<Ballena> obtenerTodas() {
        return ballenaService.obtenerTodas();
    }

    // Obtener ballena por ID
    @GetMapping("/{id}")
    public Optional<Ballena> obtenerPorId(@PathVariable Long id) {
        return ballenaService.obtenerPorId(id);
    }

    // Crear nueva ballena
    @PostMapping
    public Ballena agregar(@RequestBody Ballena ballena) {
        return ballenaService.agregar(ballena);
    }

    // Actualizar ballena
    @PutMapping("/{id}")
    public Ballena actualizar(@PathVariable Long id, @RequestBody Ballena ballena) {
        return ballenaService.actualizar(id, ballena);
    }

    // Eliminar ballena
    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable Long id) {
        return ballenaService.eliminar(id);
    }
}

