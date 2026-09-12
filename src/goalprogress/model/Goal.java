package goalprogress.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Goal {

    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate deadline;
    private int weeklyTargetMinutes;
    private Priority priority;
    private List<Task> tasks;

    public Goal(
            String name,
            String description,
            LocalDate startDate,
            LocalDate deadline,
            int weeklyTargetMinutes,
            Priority priority) {

        if (deadline.isBefore(startDate)) {
            throw new IllegalArgumentException("Deadline cannot be before start date.");
        }

        if (weeklyTargetMinutes <= 0) {
            throw new IllegalArgumentException("Weekly target must be greater than zero.");
        }

        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.deadline = deadline;
        this.weeklyTargetMinutes = weeklyTargetMinutes;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public int getWeeklyTargetMinutes() {
        return weeklyTargetMinutes;
    }

    public Priority getPriority() {
        return priority;
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }
}