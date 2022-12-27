Feature: Nationalities Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario Outline: Add Nationality
    Given Click on the element in left nav
      | setupOne      |
      | parameters    |
      | nationalities |
    When Click on the element in the Dialog Content
      | addButton |
    Then User sending the keys in Dialog Content
      | nameInput | <name> |
    And Click on the element in the Dialog Content
      | saveButton |
    Then Success message should be displayed
    Examples:
      | name       |
      | xTestmania |

  Scenario Outline: Edit Nationalities
    Given Click on the element in left nav
      | setupOne      |
      | parameters    |
      | nationalities |
    When User sending the keys in Dialog Content
      | searchInput | <name> |
    And Click on the element in the Dialog Content
      | searchButton |
    Then Wait until results are ready
    When Click on the element in the Dialog Content
      | gradeLevelEdit |
    And User sending the keys in Dialog Content
      | nameInput | <nameE> |
    And Click on the element in the Dialog Content
      | saveButton |
    Then Success message should be displayed
    Examples:
      | name | nameE |
      | xTestmania | xTestmaniax |


  Scenario Outline: Delete Nationalities
    Given Click on the element in left nav
      | setupOne      |
      | parameters    |
      | nationalities |
    When User sending the keys in Dialog Content
      | searchInput | <nameE> |
    And Click on the element in the Dialog Content
      | searchButton |
    Then Wait until results are ready
    When Click on the element in the Dialog Content
      | deleteButton    |
      | deleteDialogBtn |
    Then Success message should be displayed
    Examples:
      | nameE       |
      | xTestmaniax |



