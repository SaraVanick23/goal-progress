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
    private List<Objective> objectives;

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
        this.objectives = new ArrayList<>();
    }

    public void addObjective(Objective objective) {
        objectives.add(objective);
    }

    public void removeObjective(Objective objective) {
        objectives.remove(objective);
    }

    public List<Task> getAllTasks() {
        List<Task> allTasks = new ArrayList<>();

        for (Objective objective : objectives) {
            allTasks.addAll(objective.getTasks());
        }

        return allTasks;
    }

    public double getProgressPercentage() {
        List<Task> tasks = getAllTasks();

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

    public List<Objective> getObjectives() {
        return new ArrayList<>(objectives);
    }
}