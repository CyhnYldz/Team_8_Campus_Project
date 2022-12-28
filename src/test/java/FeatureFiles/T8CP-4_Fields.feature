Feature: Fields Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario Outline: Add Field
    And Click on the element in left nav
      | setupOne   |
      | parameters |
      | fields     |

    And Click on the element in the Dialog Content
      | addButtonFields |

    And User sending the keys in Form Content
      | nameInput | <name> |

    And Click on the element in the Dialog Content
      | fieldType |
      | integer |
      | saveButton |

    Then Success message should be displayed

    Examples:
      | name |
      | metcan |

  Scenario Outline: Edit Field
    And Click on the element in left nav
      | setupOne   |
      | parameters |
      | fields     |

    And Click on the element in the Dialog Content
      | editButton |

    And User sending the keys in Form Content
      | nameInput | <name> |

    And Click on the element in the Dialog Content
      | saveButton |

    Then Success message should be displayed

    Examples:
      | name |
      | canmet |

  Scenario: Delete Field
    And Click on the element in left nav
      | setupOne   |
      | parameters |
      | fields     |

    When User delete item from Dialog
      | canmet |

    Then Success message should be displayed

