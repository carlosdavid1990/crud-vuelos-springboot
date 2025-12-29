package com.example.demo.service;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.Vuelo;
import com.example.demo.repositories.VueloRepositories;
import com.example.demo.utils.FechaUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class VueloService {

    private final VueloRepositories vueloRepositories;
    private final FechaUtils fechaUtils;

    public VueloService(VueloRepositories vueloRepositories, FechaUtils fechaUtils) {
        this.vueloRepositories = vueloRepositories;
        this.fechaUtils = fechaUtils;
    }
    // Obtiene todos los vuelos aplicando filtros opcionales
    public List<Vuelo> findAll(String empresa,
                               String lugarLlegada,
                               LocalDate fechaSalida,
                               String ordenarPor,
                               String ordenar) {
// Se define un comparador por defecto (fecha de salida)
        Comparator<Vuelo> comparator = Comparator.comparing(Vuelo::getFechaSalida);
        // Si se indica un campo por el que ordenar, se cambia el comparador
        if ("empresa".equalsIgnoreCase(ordenarPor)) {
            comparator = Comparator.comparing(Vuelo::getEmpresa);
        } else if ("lugarLlegada".equalsIgnoreCase(ordenarPor)) {
            comparator = Comparator.comparing(Vuelo::getLugarLlegada);
        }
// Si el orden es descendente, se invierte el comparador
        if ("DESC".equalsIgnoreCase(ordenar)) {
            comparator = comparator.reversed();
        }
// Se filtran los vuelos según los parámetros recibidos
        return vueloRepositories .findAll().stream()
                .filter(v -> empresa == null || v.getEmpresa().equalsIgnoreCase(empresa))
                .filter(v -> lugarLlegada == null || v.getLugarLlegada().equalsIgnoreCase(lugarLlegada))
                .filter(v -> fechaSalida == null || v.getFechaSalida().equals(fechaSalida))
                .sorted(comparator)
                .toList();
    }

    // Busca un vuelo por ID
    public Vuelo findById(int id) {
        return vueloRepositories.findById(id)
                .orElseThrow(() -> new NotFoundException("Vuelo no encontrado"));
    }
    // Guarda un vuelo nuevo o actualizado
    public Vuelo save(Vuelo vuelo) {
    // Validación: el nombre del vuelo es obligatorio
        if (vuelo.getNombreVuelo() == null || vuelo.getNombreVuelo().isEmpty()) {
            throw new BadRequestException("Nombre de vuelo obligatorio");
        }
        // Validación: la fecha de salida no puede ser posterior a la de llegada


        if (!fechaUtils.fechasValidas(vuelo.getFechaSalida(), vuelo.getFechaLlegada())) {
            throw new IllegalArgumentException("La fecha de salida no puede ser posterior a la de llegada");
        }



        return vueloRepositories.save(vuelo);
    }
    // Elimina un vuelo existente
    public void delete(int id) {
        findById(id);
        vueloRepositories.delete(id);
    }
    // Actualiza un vuelo existente
    public Vuelo update(int id, Vuelo vueloActualizado) {

        Vuelo vueloExistente = findById(id);

        if (vueloActualizado.getNombreVuelo() == null || vueloActualizado.getNombreVuelo().isEmpty()) {
            throw new BadRequestException("Nombre de vuelo obligatorio");
        }

        if (!fechaUtils.fechasValidas(
                vueloActualizado.getFechaSalida(),
                vueloActualizado.getFechaLlegada())) {
            throw new BadRequestException("Fechas inválidas");
        }

        vueloActualizado.setId(vueloExistente.getId());

        return vueloRepositories.save(vueloActualizado);
    }

}
