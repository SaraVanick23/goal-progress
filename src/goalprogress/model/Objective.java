package goalprogress.model;

import java.util.ArrayList;
import java.util.List;

public class Objective {

    private String name;
    private String description;
    private Priority priority;
    private List<Task> tasks;

    public Objective(String name, String description, Priority priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public double getProgressPercentage() {
        if (tasks.isEmpty()) {
            return 0;
        }

        int completedTasks = 0;

        for (Task task : tasks) {
            if (task.getStatus() == TaskStatus.COMPLETED) {
                completedTasks++;
            }
        }

        return completedTasks * 100.0 / tasks.size();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }
}