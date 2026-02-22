package com.example.todo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final TodoController todoController;

    public DashboardController(TodoController todoController) {
        this.todoController = todoController;
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        List<TodoController.Task> allTasks = todoController.listTasks();
        List<TodoController.Task> active = allTasks.stream()
                .filter(t -> !t.isCompleted())
                .collect(Collectors.toList());
        List<TodoController.Task> completed = allTasks.stream()
                .filter(TodoController.Task::isCompleted)
                .collect(Collectors.toList());
        model.addAttribute("activeTasks", active);
        model.addAttribute("completedTasks", completed);
        return "index";
    }
}
