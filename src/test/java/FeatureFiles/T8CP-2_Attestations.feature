Feature: Human Resources Attestations Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully


  Scenario Outline: Create Attestations

    And Click on the element in left nav
      | humanResources      |
      | setupHumanResources |
      | attestations        |

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


  Scenario Outline: Edit Attestations

    And Click on the element in left nav
      | humanResources      |
      | setupHumanResources |
      | attestations        |

    When User Edit The "<name>" "<nameInput>"

    And Click on the element in the Dialog Content
      | saveButton |

    Then Success message should be displayed

    Examples:
      | name    |  | nameInput |
      | ktmlyvz |  | ktmlyvz1  |


  Scenario Outline: Delete Attestations

    And Click on the element in left nav
      | humanResources      |
      | setupHumanResources |
      | attestations        |

    When User Delete The "<nameInput>"

    Then Success message should be displayed

    Examples:
      | nameInput |
      | ktmlyvz1  |