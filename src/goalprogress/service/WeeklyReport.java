package goalprogress.service;

import goalprogress.model.WeeklyPlan;

public class WeeklyReport {

    private WeeklyPlan weeklyPlan;
    private ProgressAnalyzer analyzer;

    public WeeklyReport(WeeklyPlan weeklyPlan, ProgressAnalyzer analyzer) {
        this.weeklyPlan = weeklyPlan;
        this.analyzer = analyzer;
    }

    public String generate() {
        double completion =
                analyzer.calculateWeeklyTaskCompletion(weeklyPlan);

        double timePercentage =
                analyzer.calculatePlannedVsActualTime(weeklyPlan);

        StringBuilder report = new StringBuilder();

        report.append("WEEKLY PROGRESS REPORT\n");
        report.append("======================\n\n");

        report.append("Period: ")
                .append(weeklyPlan.getStartDate())
                .append(" to ")
                .append(weeklyPlan.getEndDate())
                .append("\n\n");

        report.append("Tasks planned: ")
                .append(weeklyPlan.getTasks().size())
                .append("\n");

        report.append("Tasks completed: ")
                .append(weeklyPlan.getCompletedTaskCount())
                .append("\n");

        report.append("Tasks rescheduled: ")
                .append(weeklyPlan.getRescheduledTaskCount())
                .append("\n\n");

        report.append("Planned time: ")
                .append(formatMinutes(weeklyPlan.getTotalEstimatedMinutes()))
                .append("\n");

        report.append("Actual time: ")
                .append(formatMinutes(weeklyPlan.getActualMinutes()))
                .append("\n\n");

        report.append(String.format(
                "Task completion: %.1f%%\n",
                completion
        ));

        report.append(String.format(
                "Actual time compared to planned time: %.1f%%\n\n",
                timePercentage
        ));

        report.append("Analysis:\n");
        report.append(analyzer.generateWeeklySuggestion(weeklyPlan));
        report.append("\n");

        return report.toString();
    }

    private String formatMinutes(int totalMinutes) {
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;

        return hours + "h " + minutes + "min";
    }
}