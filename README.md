# GoalProgress

GoalProgress is a Java application for planning goals and tracking progress over time.

The project allows goals to be divided into objectives and tasks, while recording study sessions and comparing planned effort with actual progress.

## Features

- Create goals with deadlines and weekly targets
- Organize goals into objectives and tasks
- Set task priorities and status
- Record study sessions
- Track estimated and actual study time
- Reschedule tasks
- Calculate goal and weekly progress
- Compare expected and actual progress
- Generate weekly progress reports
- Save reports as text files

## Technologies

- Java
- Java Collections
- Java Time API
- File handling
- IntelliJ IDEA
- Git

## Project Structure

The project is organized into two main packages:

- `model` - contains the main entities such as Goal, Objective, Task, StudySession and WeeklyPlan.
- `service` - contains the progress analysis and report generation logic.

## Example

The current version includes sample data in the `Main` class to demonstrate the application workflow.

The program creates a goal, adds objectives and tasks, records study sessions and generates a weekly report comparing planned and actual progress.

## Future Improvements

- Interactive console interface
- Data persistence with a database
- JDBC and PostgreSQL integration
- Improved progress analysis
- Automated tests

## Author

Sara Vanick