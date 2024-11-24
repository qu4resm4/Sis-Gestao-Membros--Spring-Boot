package com.pyramid.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pyramid.api.model.Membro;

public interface MembroRepository extends JpaRepository<Membro, Long> {

}
