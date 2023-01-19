package ec.edu.espe.examen2jimenez.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "turnos")
public class Turno {

    @Id
    private String id;
    private String numeroTurno;
    private String cedulaCliente;
    private String nombreCliente;
    private String codigoUsuarioEjecutivo;
    private String nombreEjecutivo;
    private LocalDate fechaHoraGeneracion;
    private LocalDate fechaHoraInicioAtencion;
    private LocalDate fechaHoraFinAtencion;
    private Integer calificacion;

}
