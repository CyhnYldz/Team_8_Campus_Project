Feature:  GradeLevels Functionalities

  Background:
    Given  Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario Outline: Add Grade Level
    Given Click on the element in left nav
      | setupOne    |
      | parameters  |
      | gradeLevels |
    When Click on the element in the Dialog Content
      | addButton |
    Then User sending the keys in Dialog Content
      | nameInput  | <name>      |
      | shortName  | <shortName> |
      | GrLvlOrder | <order>     |
    And Click on the element in the Dialog Content
      | saveButton |
    Then Success message should be displayed
    Examples:
      | name    | shortName | order |
      | axLevel1 | xLvl1     | 5  |

  Scenario Outline: Edit Grade Level
    Given Click on the element in left nav
      | setupOne    |
      | parameters  |
      | gradeLevels |
    When Find and Edit on the "<name>" element in the GradeLevel Content
    Then User sending the keys in Dialog Content
      | shortName | <shortName> |
    And Click on the element in the Dialog Content
      | saveButton |
    Then Success message should be displayed
    Examples:
      | name    | shortName |
      | axLevel1 | xLvl1E     |

  Scenario Outline: Delete Grade Level
    Given Click on the element in left nav
      | setupOne    |
      | parameters  |
      | gradeLevels |
    When Find and Delete on the "<name>" element in the GradeLevel Content
    And Click on the element in the Dialog Content
      | deleteDialogBtn |
    Then Success message should be displayed
    Examples:
      | name    |
      | axLevel1 |


