package com.parqueroma.demo.controlador;

import com.parqueroma.demo.modelo.Equipo;
import com.parqueroma.demo.repositorio.EquipoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para la gestión de Equipos (CRUD).
 * Rutas: /api/equipos
 */
@RestController 
@RequestMapping("/api/equipos") 
// CRUCIAL: Habilita la comunicación con el frontend de React
@CrossOrigin(origins = "http://localhost:3000") 
public class EquipoControlador {

    @Autowired
    private EquipoRepositorio equipoRepositorio; 

    @GetMapping
    public List<Equipo> obtenerTodosLosEquipos() {
        return equipoRepositorio.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipo createTarea(@RequestBody Equipo equipo) {
        return equipoRepositorio.save(equipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> updateEquipo(@PathVariable Long id, @RequestBody Equipo equipoModificado) {
        Optional<Equipo> equipo = equipoRepositorio.findById(id);

        if (equipo.isPresent()) {
            Equipo eq = equipo.get();
            eq.setNombre(equipoModificado.getNombre());
            eq.setEntrenador(equipoModificado.getEntrenador());
            eq.setCompletado(equipoModificado.getCompletado()); 
            
            return ResponseEntity.ok(equipoRepositorio.save(eq));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipo(@PathVariable Long id) {
        if (equipoRepositorio.existsById(id)) {
            equipoRepositorio.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}