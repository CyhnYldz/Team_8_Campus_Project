Feature: School Locations Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario Outline: Add,Edit and Delete a School Locations
    And Click on the element in left nav
      | setupOne |
      | schoolSetup |
      | locations |

    And Click on the element in the Dialog Content
      | addButton |
    And User sending the keys in Dialog Content
      | nameInput | <name>  |
      | capacityInput  | <capacity> |
      | shortName  | <shortName> |


    And Click on the element in the Dialog Content
    |toogleBar|
    |saveButton|

    #EDIT
    #And Click on the element in the Dialog Content
     # |editButton|

   And  Find and Edit on the "<name>" element in the GradeLevel Content

    And User sending the keys in Dialog Content
      | shortName | <nameEdit> |
      | capacityInput | <capacityEdit> |
    And Click on the element in the Dialog Content

      |classroomComboBox|
      |<typeOption>|

    And Click on the element in the Dialog Content

      |saveButton|
    Then Success message should be displayed

    And Find and Delete on the "<name>" element in the GradeLevel Content
    And Click on the element in the Dialog Content
      | deleteDialogBtn |
      | deleteButton |
    Then Success message should be displayed

    Examples:
      | name    | shortName | capacity |nameEdit | shortNameEdit | capacityEdit|             typeOption| defaultType|
      | emin456 | xLvl1     | 50      |  emin2  |  xxxxx        |     30 |              laboratoryComboBox |classroomComboBox |

