package pl.bialek.managementsystem3.task.utils;

import pl.bialek.managementsystem3.task.dto.TaskDto;


public class TaskUtils {

    public static void convertTitleIfEmpty(TaskDto taskDto){
        if(taskDto.getTitle()=="")
            taskDto.setTitle(null);
    }

}
