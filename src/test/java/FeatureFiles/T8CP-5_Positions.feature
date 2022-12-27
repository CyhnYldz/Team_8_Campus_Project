Feature: Human Resources Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully


  Scenario Outline: Create Position

    And Click on the element in left nav
      | humanResources      |
      | setupHumanResources |
      | positions           |


    And Click on the element in the Dialog Content
      | addButton |

    And User sending the keys in Dialog Content
      | nameInput | <name>  |
      | shortName | <sName> |

    And Click on the element in the Dialog Content
      | saveButton |

    Then Success message should be displayed

    Examples:
      | name | sName |
      | ktml | yvz   |


  Scenario Outline: Edit Positions

    And Click on the element in left nav
      | humanResources      |
      | setupHumanResources |
      | positions           |

    When User Edit The "<name>" "<nameInput>"

    And Click on the element in the Dialog Content
      | saveButton |

    Then Success message should be displayed

    Examples:
      | name |  | nameInput  |
      | ktml |  | ktml1 |


  Scenario Outline: Delete Positions

    And Click on the element in left nav
      | humanResources      |
      | setupHumanResources |
      | positions           |

    When User Delete The "<nameInput>"

    Then Success message should be displayed

    Examples:
      | nameInput |
      | ktml1     |