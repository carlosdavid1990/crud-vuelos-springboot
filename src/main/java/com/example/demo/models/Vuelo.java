package com.example.demo.models;


import java.time.temporal.ChronoUnit;

import lombok.Data;

import java.time.LocalDate;

@Data
// Clase que representa el modelo Vuelo
public class Vuelo {

    private Integer id;
    private String nombreVuelo;
    private String empresa;
    private String lugarSalida;
    private String lugarLlegada;
    private LocalDate fechaSalida;
    private LocalDate fechaLlegada;

    public Vuelo() {
    }

    public Vuelo(Integer id, String nombreVuelo, String empresa,
                 String lugarSalida, String lugarLlegada,
                 LocalDate fechaSalida, LocalDate fechaLlegada) {
        this.id = id;
        this.nombreVuelo = nombreVuelo;
        this.empresa = empresa;
        this.lugarSalida = lugarSalida;
        this.lugarLlegada = lugarLlegada;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
    }

    public long getDuracionDias() {
        if (fechaSalida == null || fechaLlegada == null) {
            return 0;
        }
        return ChronoUnit.DAYS.between(fechaSalida, fechaLlegada);
    }

}
