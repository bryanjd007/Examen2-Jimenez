package ec.edu.espe.examen2jimenez.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Animal {
    private String name;
    private Integer legs;
}
