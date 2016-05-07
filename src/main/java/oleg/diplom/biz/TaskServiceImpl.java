package oleg.diplom.biz;

import oleg.diplom.entity.Task;
import oleg.diplom.entity.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by user1 on 07.05.2016.
 */
@Component("TaskService")
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskServiceImpl() {
    }



    @Override
    public Task createTask(Task task) {
        return getTaskRepository().save(task);
    }

    public TaskRepository getTaskRepository() {
        return taskRepository;
    }

    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
}
