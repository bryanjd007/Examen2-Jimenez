package ec.edu.espe.examen2jimenez.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen2jimenez.model.Turno;
import ec.edu.espe.examen2jimenez.repository.TurnoRepository;
import ec.edu.espe.examen2jimenez.service.TurnoService;

@RestController
@RequestMapping(value = "api/turno")
public class TurnoController {
    private final TurnoRepository turnoRepository;
    private final TurnoService turnoService;

    public TurnoController(TurnoRepository turnoRepository, TurnoService turnoService) {
        this.turnoRepository = turnoRepository;
        this.turnoService = turnoService;
    }

    @GetMapping(value = "/{cedula}/{nombreCompleto}")
    public ResponseEntity<List<Turno>> obtenerTurnoPorCedulaYNombreCompleto(@PathVariable("cedula") String cedula,
            @PathVariable("nombreCompleto") String nombreCompleto) {
        List<Turno> turno = this.turnoService.findByCedulaAndNombreCompleto(cedula, nombreCompleto);
        if (turno != null) {
            return ResponseEntity.ok(turno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/{numeroTurno}/{codigoUsuarioEjecutivo}")
    public ResponseEntity<List<Turno>> obtenerTurnoPorNumeroTurnoYcodigoUsuarioEjecutivo(
            @PathVariable("numeroTurno") String numeroTurno,
            @PathVariable("codigoUsuarioEjecutivo") String codigoUsuarioEjecutivo) {
        List<Turno> turno = this.turnoService.findByNumeroTurnoAndcodigoUsuarioEjecutivo(numeroTurno,
                codigoUsuarioEjecutivo);
        if (turno != null) {
            return ResponseEntity.ok(turno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/{numeroTurno}")
    public ResponseEntity<List<Turno>> obtenerTurnoPorNumeroTurnoSinAtender(
            @PathVariable("numeroTurno") String numeroTurno) {
        List<Turno> turno = this.turnoService.findByNumeroTurnoSinAtender(numeroTurno);
        if (turno != null) {
            return ResponseEntity.ok(turno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/{cedula}/{nombreCompleto}/{codigoUsuarioEjecutivo}")
    public ResponseEntity<Turno> generarTurno(@PathVariable("cedula") String cedula,
            @PathVariable("nombreCompleto") String nombreCompleto,
            @PathVariable("codigoUsuarioEjecutivo") String codigoUsuarioEjecutivo) {
        Turno turno = this.turnoService.generarTurno(cedula, nombreCompleto, codigoUsuarioEjecutivo);
        if (turno != null) {
            return ResponseEntity.ok(turno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/{numeroTurno}/{fechaHoraFinAtencion}")
    public ResponseEntity<Turno> actualizarTurno(@PathVariable("numeroTurno") String numeroTurno, @PathVariable("fechaHoraFinAtencion") LocalDateTime fechaHoraFinAtencion) {
        Turno turno = this.turnoService.findByNumeroTurnoAndFechaHoraFinAtencion(numeroTurno, fechaHoraFinAtencion);
        if (turno != null) {
            return ResponseEntity.ok(turno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}