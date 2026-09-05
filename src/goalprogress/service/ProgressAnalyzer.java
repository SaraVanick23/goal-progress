package goalprogress.service;

import goalprogress.model.Goal;
import goalprogress.model.Task;
import goalprogress.model.WeeklyPlan;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ProgressAnalyzer {

    public double calculateWeeklyTaskCompletion(WeeklyPlan weeklyPlan) {
        int totalTasks = weeklyPlan.getTasks().size();

        if (totalTasks == 0) {
            return 0;
        }

        return weeklyPlan.getCompletedTaskCount() * 100.0 / totalTasks;
    }

    public double calculatePlannedVsActualTime(WeeklyPlan weeklyPlan) {
        int plannedMinutes = weeklyPlan.getTotalEstimatedMinutes();

        if (plannedMinutes == 0) {
            return 0;
        }

        return weeklyPlan.getActualMinutes() * 100.0 / plannedMinutes;
    }

    public double calculateExpectedGoalProgress(Goal goal, LocalDate currentDate) {
        if (currentDate.isBefore(goal.getStartDate())) {
            return 0;
        }

        if (currentDate.isAfter(goal.getDeadline())) {
            return 100;
        }

        long totalDays = ChronoUnit.DAYS.between(
                goal.getStartDate(),
                goal.getDeadline()
        );

        long elapsedDays = ChronoUnit.DAYS.between(
                goal.getStartDate(),
                currentDate
        );

        if (totalDays == 0) {
            return 100;
        }

        return elapsedDays * 100.0 / totalDays;
    }

    public double calculateProgressDifference(Goal goal, LocalDate currentDate) {
        double actualProgress = goal.getProgressPercentage();
        double expectedProgress = calculateExpectedGoalProgress(goal, currentDate);

        return actualProgress - expectedProgress;
    }

    public String analyzeGoalPace(Goal goal, LocalDate currentDate) {
        double difference = calculateProgressDifference(goal, currentDate);

        if (difference >= 0) {
            return "You are on track with this goal.";
        }

        if (difference >= -10) {
            return "You are slightly behind the expected pace.";
        }

        return "Your current progress is below the expected pace for this deadline.";
    }

    public String generateWeeklySuggestion(WeeklyPlan weeklyPlan) {
        double taskCompletion = calculateWeeklyTaskCompletion(weeklyPlan);

        if (weeklyPlan.getTasks().isEmpty()) {
            return "No tasks were planned for this week.";
        }

        if (taskCompletion >= 80) {
            return "Your weekly plan is progressing well.";
        }

        if (taskCompletion >= 50) {
            return "Part of the weekly plan was completed. Review the remaining tasks before planning the next week.";
        }

        return "The completed workload was below the weekly plan. Consider adjusting the next plan or reviewing your available time.";
    }

    public double calculateEstimateAccuracy(Task task) {
        int estimated = task.getEstimatedMinutes();
        int actual = task.getTotalStudyMinutes();

        if (estimated == 0) {
            return 0;
        }

        return actual * 100.0 / estimated;
    }
}