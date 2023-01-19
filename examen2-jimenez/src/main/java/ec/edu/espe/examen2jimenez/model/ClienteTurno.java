package ec.edu.espe.examen2jimenez.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteTurno {
    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldo;
}