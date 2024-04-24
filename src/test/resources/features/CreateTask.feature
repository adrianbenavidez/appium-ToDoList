Feature: Create New Task

  Scenario: The user can add new task
    Given Click Add new Task
    Given Enter Due Date
    Given Enter Taskname
    Given Enter Time
    When Click Save
    Then Task added successfully

  Scenario Outline: The user can add new task with Example Table
    Given Click Add new Task
    Given Enter "<TaskName>"
    Given Enter Due Date
    Given Enter Time
    When Click Save
    Then Task added successfully

    Examples:
      | TaskName |
      | Task 2   |
      | Task 3   |