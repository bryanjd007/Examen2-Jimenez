package ec.edu.espe.examen2jimenez.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen2jimenez.model.Turno;
import ec.edu.espe.examen2jimenez.repository.TurnoRepository;

@Service
public class TurnoService {

    private final TurnoRepository turnoRepository;

    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public List<Turno> findByCedulaAndNombreCompleto(String cedula, String nombreCompleto) {
        return this.turnoRepository.findByCedulaAndNombreCompleto(cedula, nombreCompleto);
    }

    public List<Turno> findByNumeroTurnoAndcodigoUsuarioEjecutivo(String numeroTurno, String codigoUsuarioEjecutivo) {
        return this.turnoRepository.findByNumeroTurnoAndcodigoUsuarioEjecutivo(numeroTurno, codigoUsuarioEjecutivo);
    }

    public List<Turno> findByNumeroTurnoSinAtender(String numeroTurno) {
        return this.turnoRepository.findByNumeroTurnoSinAtender(numeroTurno);
    }


    public List<Turno> findByNumeroTurnoAndFechaHoraFinAtencion(String numeroTurno, LocalDateTime fechaHoraFinAtencion) {
        return this.turnoRepository.findByNumeroTurnoAndFechaHoraFinAtencion(numeroTurno, fechaHoraFinAtencion);
    }

    public List<Turno> findByCedulaAndNumeroTurnoAndCalificacion(String cedula, String numeroTurno, Integer calificacion) {
        return this.turnoRepository.findByCedulaAndNumeroTurnoAndCalificacion(cedula, numeroTurno, calificacion);
    }

    public Turno generarTurno(String cedula, String nombreCompleto, String codigoUsuarioEjecutivo) {
        return null;
    }
}
