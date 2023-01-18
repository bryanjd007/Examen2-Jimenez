package ec.edu.espe.examen2jimenez.service;

import ec.edu.espe.examen2jimenez.model.Animal;
import ec.edu.espe.examen2jimenez.model.Exercise;
import ec.edu.espe.examen2jimenez.repository.ExerciseRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {

    private final ExerciseRepo exerciseRepo;

    public ExerciseService(ExerciseRepo exerciseRepo){
        this.exerciseRepo = exerciseRepo;
    }

    public List<Exercise> findAllExercisesByAge(Integer age){

        List<Exercise> opExercise = exerciseRepo.findByAge(age);

        //AQUI VA TODA LA LOGICA DE NEGOCIO
        /*if(opExercise.size() > 0){
            return opExercise;
        }else {
            return null;
        }*/

        return opExercise;
    }

    //guardar entrefechas
    public String save(){
        OffsetDateTime date = OffsetDateTime.now();
        LocalDateTime date2 = LocalDateTime.now();

        exerciseRepo.save(
            Exercise.builder()
            .name("DIEGO")
            .age(25)
            .createDate(date.toLocalDateTime())
            .executeDate(date2).build());

        return "Success";
    }
}
