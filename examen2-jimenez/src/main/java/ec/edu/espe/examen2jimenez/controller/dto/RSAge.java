package ec.edu.espe.examen2jimenez.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RSAge {
    private String name;
    private Integer age;
    private List<String> fruit;
}
