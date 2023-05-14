package pl.bialek.managementsystem3.task.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {
    @NotNull
    @Size(min = 2,max = 64)
    protected String title;
    protected String description;
    @NotNull
    protected String deadlineDate;

    public TaskDto() {
    }

    public TaskDto(String title, String description, String deadlineDate) {
        this.title = title;
        this.description = description;
        this.deadlineDate = deadlineDate;
    }

}
