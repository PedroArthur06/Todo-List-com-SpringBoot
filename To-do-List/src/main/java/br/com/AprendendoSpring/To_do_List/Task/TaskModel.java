package br.com.AprendendoSpring.To_do_List.Task;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

  /**
   * ID
   * Usuário (ID_USUARIO)
   * Descrição
   * Título
   * Data de inicio
   * Data de término
   * Prioridade
   */

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;
  private String description;

  @Column(length = 50)
  private String title;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private String priority;

  private UUID userId;

  @CreationTimestamp
  private LocalDateTime createdAt;

}