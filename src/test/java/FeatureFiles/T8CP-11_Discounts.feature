Feature: Discount Functionalities

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario Outline: Add Discount
    Given Click on the element in left nav
      | setupOne   |
      | parameters |
      | discounts  |
    When Click on the element in the Dialog Content
      | addButton |
    Then User sending the keys in Dialog Content
      | description     | <description>     |
      | integrationCode | <integrationCode> |
      | priority        | <priority>        |
    And Click on the element in the Dialog Content
      | toggleBar  |
      | toggleBar  |
      | saveButton |
    Then Success message should be displayed
    Examples:
      | description   | integrationCode | priority |
      | xtestDiscount | x1397           | 100001   |

  Scenario Outline: Edit Discount
    Given Click on the element in left nav
      | setupOne   |
      | parameters |
      | discounts  |
    When User sending the keys in Dialog Content
      | searchInputDescription | <description> |
    And Click on the element in the Dialog Content
      | searchButton   |
      Then Wait until results are ready
      And Click on the element in the Dialog Content
      | gradeLevelEdit |
    And User sending the keys in Dialog Content
      | integrationCode | <integrationCodeEdit> |
    And Click on the element in the Dialog Content
      | saveButton |
    Then Success message should be displayed
    Examples:
      | description | integrationCodeEdit |
      | xtestDiscount | xx1397xx |

    Scenario Outline: Delete Discount
      Given Click on the element in left nav
        | setupOne   |
        | parameters |
        | discounts  |
      When User sending the keys in Dialog Content
        | searchInputDescription | <description> |
      And Click on the element in the Dialog Content
        | searchButton   |
      Then Wait until results are ready
      And Click on the element in the Dialog Content
      |deleteButton|
      |deleteDialogBtn|
      Then Success message should be displayed
      Examples:
        | description |
        | xtestDiscount |