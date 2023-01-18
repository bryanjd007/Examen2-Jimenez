package ec.edu.espe.examen2jimenez.repository;

import ec.edu.espe.examen2jimenez.model.Exercise;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepo extends MongoRepository<Exercise, String> {

    Optional<Exercise> findByName(String name);

    List<Exercise> findByAge(Integer age);

    List<Exercise> findByAnimalsName(String name);

    List<Exercise> findByNameAndAgeBetween(String name, Integer from, Integer to);

    @Query("{'name': ?0,'executeDate' : { $lt: ?1, $gt: ?2 } }")
    Optional<List<Record>> findByNameAndExecuteDateBetween(String name, LocalDateTime date2, LocalDateTime date1);
}
