package pl.bialek.managementsystem3.task;

import pl.bialek.managementsystem3.task.dto.TaskDto;
import pl.bialek.managementsystem3.task.dto.TaskMainDto;
import pl.bialek.managementsystem3.utils.DateUtils;

public class TaskMapper {

    public static Task mapToTask(TaskDto taskDto){
        return new Task(taskDto.getTitle(), taskDto.getDescription(), DateUtils.formatStringToDate(taskDto.getDeadlineDate()));
    }

    public static TaskMainDto mapToTaskMainDto(Task task){
        return new TaskMainDto(task.getTitle(), task.getDescription(),DateUtils.formatDate(task.getDeadline())
                , task.getId(), task.getStatus());
    }

}
