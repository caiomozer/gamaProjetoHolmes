package br.com.itau.techinsiders.holmes.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import br.com.itau.techinsiders.holmes.models.Departamento;

public interface DepartamentoRepository extends CrudRepository<Departamento, Long> {

    public Optional<Departamento> findDepartamentoByDepartamento(String depto);
    
}