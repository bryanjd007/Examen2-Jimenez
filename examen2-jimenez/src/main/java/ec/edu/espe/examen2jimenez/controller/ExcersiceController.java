package ec.edu.espe.examen2jimenez.controller;

import ec.edu.espe.examen2jimenez.controller.dto.RQAge;
import ec.edu.espe.examen2jimenez.controller.dto.RSAge;
import ec.edu.espe.examen2jimenez.controller.mapper.AgeMapper;
import ec.edu.espe.examen2jimenez.model.Animal;
import ec.edu.espe.examen2jimenez.model.Exercise;
import ec.edu.espe.examen2jimenez.repository.ExerciseRepo;
import ec.edu.espe.examen2jimenez.service.ExerciseService;
import ec.edu.espe.examen2jimenez.utils.Utils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/exercise")
public class ExcersiceController {
    private final ExerciseRepo exerciseRepo; //Esto esta MAL, solo se hize por rapidez, no replicar NUNCA

    private final ExerciseService exerciseService; //Esto esta bien, al controlador solo se debe inyectar la clase de servicios

    public ExcersiceController(ExerciseRepo exerciseRepo, ExerciseService exerciseService){
        this.exerciseRepo = exerciseRepo;
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public List<Exercise> get(){
        return exerciseRepo.findAll();
    }

    @GetMapping(value = "/find")
    public Exercise getByName(){
        Optional<Exercise> exercise = exerciseRepo.findByName("David");
        return (exercise.isPresent()) ? exercise.get() : null;
    }

    @PutMapping(value = "/simple")
    public String update(){
        Optional<Exercise> opExercise = exerciseRepo.findByName("David");
        if(opExercise.isPresent()){
            Exercise exercise = opExercise.get();
            exercise.setName("Enrique");
            exerciseRepo.save(exercise);
            return "Success";
        }else {
            return "Failure";
        }
    }

    @PutMapping(value = "/complex")
    public String updateComplex(){
        Optional<Exercise> opExercise = exerciseRepo.findByName("Enrique");
        if(opExercise.isPresent()){
            Exercise exercise = opExercise.get();
            exercise.getFruits().add("Babaco");
            exercise.getAnimals().add(Animal.builder().name("Pato").legs(2).build());
            exerciseRepo.save(exercise);
            return "Success";
        }else {
            return "Failure";
        }
    }

    @GetMapping(value = "/inside")
    public Object getByInsideKey(){
        List<Exercise> opExercise = exerciseRepo.findByAnimalsName("vaca");

        if(opExercise.size() > 0){
            return opExercise;
        }else {
            return "Failure";
        }
    }

    @GetMapping(value = "/between")
    public Object getByNameAndAges(){
        List<Exercise> opExercise = exerciseRepo.findByNameAndAgeBetween("Enrique", 30,40);

        if(opExercise.size() > 0){
            return opExercise;
        }else {
            return "Failure";
        }
    }

    @GetMapping(value = "/age/{message}")
    public ResponseEntity<Object> getByAge(
            @PathVariable("message") String message,
            @RequestBody RQAge request){
        //Se debe validar los datos de entrada
        if(!Utils.hasAllAttributes(request)){
            throw new RuntimeException("Faltan parametros");
        }

        System.out.println("Varible Path ->" + message);

        List<Exercise> dbExercises = exerciseService.findAllExercisesByAge(request.getAge());
        List<RSAge> exercises = new ArrayList<>();
        RSAge exercise;

        if(dbExercises.size() > 0){
            for(Exercise dbExercise: dbExercises){
                exercise = AgeMapper.map(dbExercise);
                exercises.add(exercise);
            }
            return ResponseEntity.ok(exercises);
        }else {
            throw new RuntimeException("No se encontraron registros con esa edad");
        }
    }

    @PostMapping
    public String save(){
        exerciseRepo.save(
                Exercise.builder()
                        .name("Tomas")
                        .age(55)
                        .fruits(
                                List.of("tomate","pera","durazno")
                        )
                        .animals(
                                List.of(
                                        Animal.builder().name("vaca").legs(4).build(),
                                        Animal.builder().name("toro").legs(4).build()
                                )
                        )
                        .build()
        );
        return "Success";
    }

}
