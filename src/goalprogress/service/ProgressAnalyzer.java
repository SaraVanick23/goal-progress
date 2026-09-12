package goalprogress.service;

import goalprogress.model.WeeklyPlan;

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

    public String generateWeeklySuggestion(WeeklyPlan weeklyPlan) {
        double taskCompletion =
                calculateWeeklyTaskCompletion(weeklyPlan);

        if (weeklyPlan.getTasks().isEmpty()) {
            return "No tasks were planned for this week.";
        }

        if (taskCompletion >= 80) {
            return "Your weekly plan is progressing well.";
        }

        if (taskCompletion >= 50) {
            return "Part of the weekly plan was completed. Review the remaining tasks before planning the next week.";
        }

        return "The completed workload was below the weekly plan. Consider reviewing your available time.";
    }
}