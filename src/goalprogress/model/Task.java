package goalprogress.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task {

    private String name;
    private String description;
    private int estimatedMinutes;
    private LocalDate originalDate;
    private LocalDate plannedDate;
    private TaskStatus status;
    private List<StudySession> studySessions;

    public Task(String name, String description, int estimatedMinutes, LocalDate plannedDate) {
        if (estimatedMinutes <= 0) {
            throw new IllegalArgumentException("Estimated time must be greater than zero.");
        }

        this.name = name;
        this.description = description;
        this.estimatedMinutes = estimatedMinutes;
        this.originalDate = plannedDate;
        this.plannedDate = plannedDate;
        this.status = TaskStatus.PENDING;
        this.studySessions = new ArrayList<>();
    }

    public void addStudySession(StudySession studySession) {
        studySessions.add(studySession);

        if (status == TaskStatus.PENDING) {
            status = TaskStatus.IN_PROGRESS;
        }
    }

    public void complete() {
        status = TaskStatus.COMPLETED;
    }

    public void reschedule(LocalDate newDate) {
        if (newDate == null) {
            throw new IllegalArgumentException("New date cannot be null.");
        }

        plannedDate = newDate;
    }

    public int getTotalStudyMinutes() {
        int total = 0;

        for (StudySession session : studySessions) {
            total += session.getDurationMinutes();
        }

        return total;
    }

    public boolean isRescheduled() {
        return !originalDate.equals(plannedDate);
    }

    public boolean isOverdue(LocalDate today) {
        return plannedDate.isBefore(today)
                && status != TaskStatus.COMPLETED;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getEstimatedMinutes() {
        return estimatedMinutes;
    }

    public LocalDate getOriginalDate() {
        return originalDate;
    }

    public LocalDate getPlannedDate() {
        return plannedDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public List<StudySession> getStudySessions() {
        return new ArrayList<>(studySessions);
    }
}