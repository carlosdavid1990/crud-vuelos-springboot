package com.example.demo.controller;

import com.example.demo.models.Vuelo;
import com.example.demo.service.VueloService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

// Controlador REST que expone los endpoints de la API de vuelos
@RestController
@RequestMapping("/vuelos")
public class VueloController {

    private final VueloService service;


    public VueloController(VueloService service) {
        this.service = service;
    }

    // Endpoint para obtener todos los vuelos
    // Permite aplicar filtros y ordenación mediante parámetros
    @GetMapping
    public List<Vuelo> getAll(
            @RequestParam(required = false) String empresa,
            @RequestParam(required = false) String lugarLlegada,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fechaSalida,
            @RequestParam(required = false) String ordenarPor,
            @RequestParam(required = false, defaultValue = "ASC") String ordenar) {

        return service.findAll(empresa, lugarLlegada, fechaSalida, ordenarPor, ordenar);
    }

    // Endpoint para obtener un vuelo concreto por su ID
    @GetMapping("/{id}")
    public Vuelo getById(@PathVariable int id) {
        return service.findById(id);
    }

    // Endpoint para actualizar un vuelo existente
    @PutMapping("/{id}")
    public Vuelo update(@PathVariable int id, @RequestBody Vuelo vuelo) {
        return service.update(id, vuelo);
    }


    // Endpoint para crear o actualizar un vuelo
    @PostMapping
    public Vuelo create(@RequestBody Vuelo vuelo) {
        return service.save(vuelo);
    }



    // Endpoint para eliminar un vuelo por ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
