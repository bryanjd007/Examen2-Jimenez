package ec.edu.espe.examen2jimenez.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.examen2jimenez.model.Ejecutivo;

@Repository
public interface EjecutivoRepository extends MongoRepository<Ejecutivo, String> {

    List<Ejecutivo> findByNumeroEscritorioAsignado(String numeroEscritorioAsignado);

    List<Ejecutivo> findByNombreCompleto(String nombreCompleto);

}
