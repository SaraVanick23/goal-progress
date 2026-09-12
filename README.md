# GoalProgress

GoalProgress is a Java application for planning goals and tracking progress over time.

The project allows goals to be divided into tasks, while recording study sessions and comparing planned effort with actual progress.

## Features

- Create goals with deadlines and weekly targets
- Organize goals into tasks
- Set priorities and task status
- Record study sessions
- Track estimated and actual study time
- Reschedule tasks
- Calculate goal and weekly progress
- Compare planned and actual study time
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

- `model` - contains the main entities such as Goal, Task, StudySession and WeeklyPlan.
- `service` - contains the progress analysis and report generation logic.

## Example

The current version includes sample data in the `Main` class to demonstrate the application workflow.

The program creates a goal, adds tasks, records study sessions and generates a weekly report comparing planned and actual progress.

## Future Improvements

- Interactive console interface
- Data persistence with a database
- JDBC and PostgreSQL integration
- Automated tests

## Author

Sara Vanick