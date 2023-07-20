package main.service;

import main.model.Task;
import main.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return StreamSupport.stream(taskRepository.findAll().spliterator(), false).toList();
    }

    public Task getById(int id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task add(Task task) {
        return taskRepository.save(task);
    }

    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }

    public Optional<Task> delete(int id) {
        return taskRepository.findById(id);
    }

    public void putTask(int id, String name, String descriptions, Date date) {
        Task task = taskRepository.findById(id).get();
        task.setName(name);
        task.setDescriptions(descriptions);
        task.setDate(date);
        taskRepository.save(task);
        responseStatus(task);
    }

    public void putAllTask(List<Task> list) {
        taskRepository.saveAll(list);
    }

    private void responseStatus(Task task) {
        if (task == null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return;
        }
        ResponseEntity.status(HttpStatus.OK).body(null);
    }
}