package com.example.demo.service;

import com.example.demo.modelo.Ballena;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BallenaService {
    private List<Ballena> ballenas = new ArrayList<>();
    private Long contadorId = 1L; // Simulamos IDs autoincrementales

    public BallenaService() {
        // Agregamos algunas ballenas de prueba
        ballenas.add(new Ballena(contadorId++, "Ballena Azul", 30, "Krill"));
        ballenas.add(new Ballena(contadorId++, "Ballena Jorobada", 16, "Peces pequeños"));
        ballenas.add(new Ballena(contadorId++, "Ballena Franca", 18, "Plancton"));
    }

    public List<Ballena> obtenerTodas() {
        return ballenas;
    }

    public Optional<Ballena> obtenerPorId(Long id) {
        return ballenas.stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    public Ballena agregar(Ballena ballena) {
        ballena.setId(contadorId++);
        ballenas.add(ballena);
        return ballena;
    }

    public Ballena actualizar(Long id, Ballena nuevaBallena) {
        for (int i = 0; i < ballenas.size(); i++) {
            if (ballenas.get(i).getId().equals(id)) {
                nuevaBallena.setId(id);
                ballenas.set(i, nuevaBallena);
                return nuevaBallena;
            }
        }
        return null; // Retorna null si no se encuentra
    }

    public boolean eliminar(Long id) {
        return ballenas.removeIf(b -> b.getId().equals(id));
    }
}

