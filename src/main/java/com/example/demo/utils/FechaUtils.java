package com.example.demo.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Clase utilitaria para operaciones relacionadas con fechas
@Component
public class FechaUtils {

    // Calcula la duración en días entre dos fechas
    public long calcularDuracionDias(LocalDate inicio, LocalDate fin) {
        return ChronoUnit.DAYS.between(inicio, fin);
    }

    // Valida que la fecha de salida no sea posterior a la de llegada
    public boolean fechasValidas(LocalDate salida, LocalDate llegada) {
        return !salida.isAfter(llegada);
    }
}
