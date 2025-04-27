package br.com.AprendendoSpring.To_do_List.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

  @Autowired
  private TaskRepository taskRepository;

  @PostMapping("/")
  public TaskModel create(@RequestBody TaskModel taskModel) {
    var task = this.taskRepository.save(taskModel);
    return task;
  }

}