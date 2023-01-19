package ec.edu.espe.examen2jimenez.repository;

import ec.edu.espe.examen2jimenez.model.Cliente;
import ec.edu.espe.examen2jimenez.model.Turno;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TurnoRepository extends MongoRepository<Cliente, String> {

    List<Turno> findByCedulaAndNombreCompleto(String cedula, String nombreCompleto);

    List<Turno> findByNumeroTurnoAndcodigoUsuarioEjecutivo(String numeroTurno, String codigoUsuarioEjecutivo);

    List<Turno> findByNumeroTurnoSinAtender(String numeroTurno);

    List<Turno> findByNumeroTurnoAndFechaHoraFinAtencion(String numeroTurno, LocalDateTime fechaHoraFinAtencion);

    List<Turno> findByCedulaAndNumeroTurnoAndCalificacion(String cedula, String numeroTurno, Integer calificacion);

}
