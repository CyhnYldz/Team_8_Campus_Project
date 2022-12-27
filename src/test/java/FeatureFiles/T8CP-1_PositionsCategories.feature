Feature: Human Resources Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully


  Scenario Outline: Create Positions Categories

    And Click on the element in left nav
      | humanResources      |
      | setupHumanResources |
      | positionCategories  |

    And Click on the element in the Dialog Content
      | addButton |

    And User sending the keys in Dialog Content
      | nameInput | <name> |

    And Click on the element in the Dialog Content
      | saveButton |

    Then Success message should be displayed

    Examples:
      | name    |
      | ktmlyvz |


  Scenario Outline: Edit Positions Categories

    And Click on the element in left nav
      | humanResources      |
      | setupHumanResources |
      | positionCategories  |

    When User Edit The "<name>" "<nameInput>"

    And Click on the element in the Dialog Content
      | saveButton |

    Then Success message should be displayed

    Examples:
      | name    |  | nameInput |
      | ktmlyvz |  | ktmlyvz1  |


  Scenario Outline: Delete Positions Categories

    And Click on the element in left nav
      | humanResources      |
      | setupHumanResources |
      | positionCategories  |

    When User Delete The "<nameInput>"

    Then Success message should be displayed

    Examples:
      | nameInput |
      | ktmlyvz1  |