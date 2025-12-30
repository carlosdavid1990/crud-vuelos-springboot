package com.example.demo.dtos;

import com.example.demo.models.Vuelo;

import java.time.temporal.ChronoUnit;


public class VueloDtos {

    private Integer id;
    private String nombreVuelo;
    private String empresa;
    private String lugarSalida;
    private String lugarLlegada;
    private long duracionDias;

    public VueloDtos(Vuelo vuelo) {
        this.id = vuelo.getId();
        this.nombreVuelo = vuelo.getNombreVuelo();
        this.empresa = vuelo.getEmpresa();
        this.lugarSalida = vuelo.getLugarSalida();
        this.lugarLlegada = vuelo.getLugarLlegada();

        // dato calculado, NO persistido
        this.duracionDias = ChronoUnit.DAYS.between(
                vuelo.getFechaSalida(),
                vuelo.getFechaLlegada()
        );
    }

    // getters
    public Integer getId() {
        return id;
    }

    public String getNombreVuelo() {
        return nombreVuelo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getLugarSalida() {
        return lugarSalida;
    }

    public String getLugarLlegada() {
        return lugarLlegada;
    }

    public long getDuracionDias() {
        return duracionDias;
    }
}
