package goalprogress.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WeeklyPlan {

    private LocalDate startDate;
    private LocalDate endDate;
    private List<Task> tasks;

    public WeeklyPlan(LocalDate startDate) {
        this.startDate = startDate;
        this.endDate = startDate.plusDays(6);
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        if (!tasks.contains(task)) {
            tasks.add(task);
        }
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public int getTotalEstimatedMinutes() {
        int total = 0;

        for (Task task : tasks) {
            total += task.getEstimatedMinutes();
        }

        return total;
    }

    public int getActualMinutes() {
        int total = 0;

        for (Task task : tasks) {
            for (StudySession session : task.getStudySessions()) {

                LocalDate sessionDate = session.getDate();

                if (!sessionDate.isBefore(startDate)
                        && !sessionDate.isAfter(endDate)) {
                    total += session.getDurationMinutes();
                }
            }
        }

        return total;
    }

    public int getCompletedTaskCount() {
        int completed = 0;

        for (Task task : tasks) {
            if (task.getStatus() == TaskStatus.COMPLETED) {
                completed++;
            }
        }

        return completed;
    }

    public int getRescheduledTaskCount() {
        int rescheduled = 0;

        for (Task task : tasks) {
            if (task.isRescheduled()) {
                rescheduled++;
            }
        }

        return rescheduled;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }
}