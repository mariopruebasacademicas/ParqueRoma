package com.parqueroma.demo.repositorio;

import com.parqueroma.demo.modelo.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de Equipos: Proporciona métodos CRUD básicos.
 */
@Repository
public interface EquipoRepositorio extends JpaRepository<Equipo, Long> {
    // Métodos CRUD básicos heredados
}
