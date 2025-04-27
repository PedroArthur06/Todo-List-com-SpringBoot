package br.com.AprendendoSpring.To_do_List.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<TaskModel, UUID> {

}