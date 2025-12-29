package com.example.demo.repositories;

import com.example.demo.models.Vuelo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class VueloRepositories {

    // Uso un Map para guardar los vuelos en memoria

    private final Map<Integer, Vuelo> vuelos = new HashMap<>();

    // Variable para generar los ids automáticamente
    private int nextId = 1;

    // Constructor donde se crean los 10 vuelos iniciales
    public VueloRepositories() {


        save(new Vuelo(null, "IB001", "Iberia", "Madrid", "Roma",
                LocalDate.of(2025, 3, 10),
                LocalDate.of(2025, 3, 11)));

        save(new Vuelo(null, "IB002", "Iberia", "Madrid", "Paris",
                LocalDate.of(2025, 3, 12),
                LocalDate.of(2025, 3, 12)));

        save(new Vuelo(null, "TK101", "Turkish Airlines", "Estambul", "Madrid",
                LocalDate.of(2025, 3, 15),
                LocalDate.of(2025, 3, 15)));

        save(new Vuelo(null, "TK102", "Turkish Airlines", "Estambul", "Berlin",
                LocalDate.of(2025, 3, 16),
                LocalDate.of(2025, 3, 17)));

        save(new Vuelo(null, "EK201", "Emirates", "Dubai", "New York",
                LocalDate.of(2025, 3, 20),
                LocalDate.of(2025, 3, 21)));

        save(new Vuelo(null, "EK202", "Emirates", "Dubai", "Buenos Aires",
                LocalDate.of(2025, 3, 22),
                LocalDate.of(2025, 3, 24)));

        save(new Vuelo(null, "LH301", "Lufthansa", "Frankfurt", "Madrid",
                LocalDate.of(2025, 3, 25),
                LocalDate.of(2025, 3, 25)));

        save(new Vuelo(null, "LH302", "Lufthansa", "Frankfurt", "Tokyo",
                LocalDate.of(2025, 3, 26),
                LocalDate.of(2025, 3, 27)));

        save(new Vuelo(null, "AF401", "Air France", "Paris", "Lisbon",
                LocalDate.of(2025, 3, 28),
                LocalDate.of(2025, 3, 28)));

        save(new Vuelo(null, "AF402", "Air France", "Paris", "New York",
                LocalDate.of(2025, 3, 29),
                LocalDate.of(2025, 3, 30)));
    }

    // Devuelve todos los vuelos
    public List<Vuelo> findAll() {
        return new ArrayList<>(vuelos.values());
    }

    // Busca un vuelo por su id
    public Optional<Vuelo> findById(int id) {
        return Optional.ofNullable(vuelos.get(id));
    }

    // Guarda un vuelo nuevo o actualiza uno existente
    public Vuelo save(Vuelo vuelo) {

        // Si es un vuelo nuevo (sin ID o con ID 0), se genera uno nuevo
        if (vuelo.getId() == null || vuelo.getId() == 0) {
            vuelo.setId(nextId++);
        }

        vuelos.put(vuelo.getId(), vuelo);
        return vuelo;
    }

    // Elimina un vuelo por id
    public void delete(int id) {
        vuelos.remove(id);
    }
}
