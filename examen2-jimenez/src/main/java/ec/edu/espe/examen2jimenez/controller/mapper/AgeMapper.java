package ec.edu.espe.examen2jimenez.controller.mapper;

import ec.edu.espe.examen2jimenez.controller.dto.RSAge;
import ec.edu.espe.examen2jimenez.model.Exercise;

public class AgeMapper {

    public static RSAge map(Exercise exercise){
        return RSAge.builder()
                .name(exercise.getName())
                .age(exercise.getAge())
                .fruit(exercise.getFruits())
                .build();
    }
}
