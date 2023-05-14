package pl.bialek.managementsystem3.task.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskMainDto extends TaskDto{

    private Long id;
    @NotNull
    private String status;

    public TaskMainDto(String title, String description, String deadlineDate, Long id, String status) {
        super(title, description, deadlineDate);
        this.id = id;
        this.status = status;
    }

}
