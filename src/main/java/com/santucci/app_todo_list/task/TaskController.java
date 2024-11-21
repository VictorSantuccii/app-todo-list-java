package com.santucci.app_todo_list.task;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
        var idUser = request.getAttribute("idUser");

        var currentDate = LocalDateTime.now();

        // Validação de datas
        if (currentDate.isAfter(taskModel.getStartAt()) || currentDate.isAfter(taskModel.getEndAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("A data de início / data de término deve ser maior do que a data atual");
        }

        if (taskModel.getStartAt().isAfter(taskModel.getEndAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("A data de início deve ser menor do que a data de término");
        }

        // Salva a tarefa
        var task = this.taskRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @GetMapping("/")
    public List<TaskModel> list(HttpServletRequest request) {
        var idUser = request.getAttribute("idUser");
        return this.taskRepository.findByIdUser((UUID) idUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody TaskModel taskModel, @PathVariable UUID id,
                                     HttpServletRequest request) {
        var task = this.taskRepository.findById(id).orElse(null);

        if (task == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Tarefa não encontrada");
        }

        var idUser = request.getAttribute("idUser");

        if (!task.getIdUser().equals(idUser)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Usuário não tem permissão para alterar essa tarefa");
        }

        // Atualiza propriedades não nulas
        copyNonNullProperties(taskModel, task);

        var taskUpdated = this.taskRepository.save(task);
        return ResponseEntity.ok().body(taskUpdated);
    }

    /**
     * Método para copiar propriedades não nulas de um objeto para outro.
     */
    private void copyNonNullProperties(Object source, Object target) {
        try {
            Class<?> clazz = source.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true); // Permite acesso a campos privados
                Object value = field.get(source); // Obtém o valor do campo
                if (value != null) { // Copia apenas se o valor não for nulo
                    field.set(target, value);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Erro ao copiar propriedades: " + e.getMessage(), e);
        }
    }
}
