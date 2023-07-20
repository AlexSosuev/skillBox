package main.controller;

import main.model.Task;
import main.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ToDoController {

    private final TaskService taskService;

    public ToDoController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getTasks());
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id) {
        Task task = taskService.getById(id);
        if (task != null) {
            return ResponseEntity.status(HttpStatus.OK).body(task);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/task/")
    public Task add(@RequestBody Task task) {
        return taskService.add(task);
    }

    @DeleteMapping("/task/")
    public void deleteAllTasks() {
        taskService.deleteAllTasks();
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<Task> delete(@PathVariable int id) {
        Optional<Task> task = taskService.delete(id);
        if (task.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/task/{id}")
    public void putTask(@PathVariable int id, String name, String descriptions, Date date) {
        taskService.putTask(id, name, descriptions, date);
    }

    @PutMapping("/task/")
    public ResponseEntity<Task> putTask(@RequestBody List<Task> list) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            list.forEach(task -> putTask(task.getId(), task.getName(), task.getDescriptions(), task.getDate()));
        } catch (Exception ex) {
            stringBuilder.append(ex);
        }
        taskService.putAllTask(list);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}