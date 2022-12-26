Feature: Grade Levels Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario Outline: Add, Edit and Delete Grade Level
    And Click on the element in left nav
      | setupOne    |
      | parameters  |
      | gradeLevels |

    And Click on the element in the Dialog Content
      | addButton |

    And User sending the keys in Dialog Content
      | nameInput  | <name>      |
      | shortName  | <shortName> |
      | GrLvlOrder | <order>     |

    And Click on the element in the Dialog Content
      | saveButton |

    Then Success message should be displayed

#    Edit GradeLevel

    And  Find and Edit on the "<name>" element in the GradeLevel Content

    And User sending the keys in Dialog Content
      | shortName | <nameEdit> |
    And Click on the element in the Dialog Content
      | saveButton |
    Then Success message should be displayed

#    Delete GradeLevel

    And  Find and Delete on the "<name>" element in the GradeLevel Content
    And Click on the element in the Dialog Content
      | deleteDialogBtn |
    Then Success message should be displayed



    Examples:
      | name    | shortName | order | nameEdit |
      | xLevel1 | xLvl1     | 101   | xLvl1E   |

