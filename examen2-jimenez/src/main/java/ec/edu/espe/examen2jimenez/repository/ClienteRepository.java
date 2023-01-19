package ec.edu.espe.examen2jimenez.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.examen2jimenez.model.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String>{
    
    Optional<Cliente> findByCedula(String cedula);
}
