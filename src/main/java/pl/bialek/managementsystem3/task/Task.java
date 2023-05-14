package pl.bialek.managementsystem3.task;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2,max = 64)
    private String title;
    private String description;
    @NotNull
    private String status;
    @NotNull
    private Date deadline;

    public Task() {
    }

    public Task(String title, String description, Date deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

}
