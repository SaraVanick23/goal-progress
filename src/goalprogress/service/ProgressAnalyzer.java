package goalprogress.service;

import goalprogress.model.Goal;

public class ProgressAnalyzer {

    public String generateSuggestion(Goal goal) {

        double progress = goal.getProgressPercentage();

        if (goal.getTasks().isEmpty()) {
            return "No tasks have been added to this goal.";
        }

        if (progress >= 80) {
            return "The goal is progressing well.";
        }

        if (progress >= 50) {
            return "Good progress. Keep working on the remaining tasks.";
        }

        return "The goal still has several tasks to complete.";
    }
}