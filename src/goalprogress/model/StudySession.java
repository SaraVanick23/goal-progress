package goalprogress.model;

import java.time.LocalDate;

public class StudySession {

    private LocalDate date;
    private int durationMinutes;
    private String notes;

    public StudySession(LocalDate date, int durationMinutes, String notes) {
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be greater than zero.");
        }

        this.date = date;
        this.durationMinutes = durationMinutes;
        this.notes = notes;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public String getNotes() {
        return notes;
    }
}