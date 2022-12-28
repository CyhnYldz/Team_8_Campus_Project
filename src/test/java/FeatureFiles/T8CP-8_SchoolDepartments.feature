Feature: School Locations Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario Outline: Add,Edit and Delete a School Locations
    And Click on the element in left nav
      | setupOne |
      | schoolSetup |
      | departments |

    And Click on the element in the Dialog Content
      | addButton |
    And User sending the keys in Dialog Content
      | nameInput | <name>  |
      | codeInput  | <codeInputData> |
    And Click on the element in the Dialog Content
      | toogleBar |
    And Click on the element in the Dialog Content
      | section|
    And User sending the keys in Dialog Content
      | shortName  | <shortNameAdd> |
      | nameInput | <name>  |
    And Click on the element in the Dialog Content
      | schoolDepartmentSectionSaveButton|
    And Click on the element in the Dialog Content
      | constants|
    And User sending the keys in Dialog Content
      | valueInput | <value>  |
      | keyInput  | <key> |

    And Click on the element in the Dialog Content
      | schoolDepartmentSectionSaveButton|

    And Click on the element in the Dialog Content
      |saveButton|
    Then Success message should be displayed

    #Edit
    And  Find and Edit on the "<name>" element in the GradeLevel Content

    And User sending the keys in Dialog Content
      | codeInput | <codeEdit> |
      | nameInput | <nameEdit> |
    And Click on the element in the Dialog Content
      | section|
    And User sending the keys in Dialog Content
      | shortName  | <shorNameEdit> |
      | nameInput | <nameEdit>  |
    And Click on the element in the Dialog Content
      | schoolDepartmentSectionSaveButton|
    And Click on the element in the Dialog Content
      | constants|
    And User sending the keys in Dialog Content
      | valueInput | <valueEdit>  |
      | keyInput  | <keyEdit> |
    And Click on the element in the Dialog Content
      | schoolDepartmentSectionSaveButton|
    And Click on the element in the Dialog Content
      |saveButton|
    Then Success message should be displayed
    And Find and Delete on the "<nameEdit>" element in the GradeLevel Content

    And Click on the element in the Dialog Content
      | deleteDialogBtn |
      | deleteButton |
    Then Success message should be displayed

    Examples:
      | name    | codeInputData | shortNameAdd |codeEdit|key   | value |nameEdit|keyEdit| valueEdit|shorNameEdit|
      | emin123 | xLvl1             |emin1     | 12345  |asd   | xxxxx |emin456 | ComboBox |othe|shortNameEdit|


