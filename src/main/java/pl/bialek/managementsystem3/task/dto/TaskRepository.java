package pl.bialek.managementsystem3.task.dto;

import org.springframework.data.repository.CrudRepository;
import pl.bialek.managementsystem3.task.Task;

public interface TaskRepository extends CrudRepository<Task,Long> {

}
