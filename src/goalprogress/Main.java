package goalprogress;

import goalprogress.model.*;
import goalprogress.service.*;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Goal javaGoal = new Goal(
                "Learn Java Backend",
                "Improve Java skills and prepare for backend internship applications.",
                LocalDate.of(2026, 9, 1),
                LocalDate.of(2026, 12, 1),
                600,
                Priority.HIGH
        );

        Task lambdaTask = new Task(
                "Review Lambda Expressions",
                "Review lambda expressions and solve practical exercises.",
                120,
                LocalDate.of(2026, 9, 2)
        );

        Task gitTask = new Task(
                "Practice Git",
                "Review Git commands and repository workflow.",
                90,
                LocalDate.of(2026, 9, 3)
        );

        Task projectTask = new Task(
                "Develop GoalProgress",
                "Implement the first version of the Java project.",
                180,
                LocalDate.of(2026, 9, 4)
        );

        javaGoal.addTask(lambdaTask);
        javaGoal.addTask(gitTask);
        javaGoal.addTask(projectTask);

        lambdaTask.addStudySession(
                new StudySession(
                        LocalDate.of(2026, 9, 2),
                        60,
                        "Reviewed lambda syntax."
                )
        );

        lambdaTask.addStudySession(
                new StudySession(
                        LocalDate.of(2026, 9, 2),
                        45,
                        "Solved lambda exercises."
                )
        );

        lambdaTask.complete();

        projectTask.addStudySession(
                new StudySession(
                        LocalDate.of(2026, 9, 4),
                        120,
                        "Created the first project structure."
                )
        );

        ProgressAnalyzer analyzer = new ProgressAnalyzer();

        String report =
                "GOAL PROGRESS REPORT\n"
                        + "====================\n\n"
                        + "Goal: " + javaGoal.getName() + "\n"
                        + "Priority: " + javaGoal.getPriority() + "\n"
                        + "Deadline: " + javaGoal.getDeadline() + "\n"
                        + String.format(
                        "Progress: %.1f%%\n",
                        javaGoal.getProgressPercentage()
                )
                        + "Analysis: "
                        + analyzer.generateSuggestion(javaGoal)
                        + "\n";

        System.out.println(report);

        ReportFileManager fileManager = new ReportFileManager();

        fileManager.save(
                report,
                "goal-progress-report.txt"
        );
    }
}