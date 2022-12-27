Feature: Document Types Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario Outline: Add,Edit and Delete Document
    And Click on the element in left nav
      | setupOne     |
      | parameters   |
      | documentType |

    And Click on the element in the Dialog Content
      | addButton |

    And User sending the keys in Form Content
      | nameInput | <name> |

    And Click on the element in the Form Content
      | stage |
      | examination |
      | saveButton |



    Examples:
      | name |
      | MetCan |