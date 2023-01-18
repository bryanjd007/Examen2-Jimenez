package ec.edu.espe.examen2jimenez.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Document(collection = "exercises")
public class Exercise {
    @Id
    private String id;

    private String name;

    private Integer age;

    private List<String> fruits;

    private List<Animal> animals;

    private LocalDateTime executeDate;

    private LocalDateTime createDate;

    @Version
    private Long version;
}
