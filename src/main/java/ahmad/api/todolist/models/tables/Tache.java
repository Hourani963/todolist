package ahmad.api.todolist.models.tables;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data // doing the work of getters and setters
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_taches")
public class Tache {

    @Id
    @GeneratedValue
    private Long id;

    private String text;

    private int importance;

    private boolean done;

    private LocalDateTime creationDate;
    private LocalDateTime doneDate;

}
