Feature: Education Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario Outline: Add,Edit and Delete a SchoolSubject Categories
    And Click on the element in left nav
      | educationSet |
      | subjectEduSetup |
      | subjectCategories |
    And Click on the element in the Dialog Content
      | addButton |

    And User sending the keys in Dialog Content
      | nameInput | <name>  |
      | codeInput | <codeInput>  |

    And Click on the element in the Dialog Content
      | saveButton |
    And Success message should be displayed

  #Edit
    And Click on the element in the Dialog Content
      | editButton |
    And User sending the keys in Dialog Content
      | nameInput | <nameEdit> |
    And Click on the element in the Dialog Content
      | saveButton |
    And Success message should be displayed
  #Delete
    And User delete item from Dialog
      | <nameEdit> |
    And Success message should be displayed

    Examples:
      | name    | codeInput | nameEdit |
      | emin12 | i43434     |emin123456    |