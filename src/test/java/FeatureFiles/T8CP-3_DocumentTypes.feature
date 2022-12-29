Feature: Document Types Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario Outline: Add Document
    And Click on the element in left nav
      | setupOne     |
      | parameters   |
      | documentType |

    And Click on the element in the Dialog Content
      | addButton |

    And User sending the keys in Form Content
      | nameInput | <name> |

    And Click on the element in the Dialog Content
      | stage               |
      | studentRegistration |

    And User press ESC button on keyboard

    And Click on the element in the Dialog Content
      | saveButton |

    Then Success message should be displayed


    Examples:
      | name   |
      | MetCan |

  Scenario Outline: Edit Document
    Given Click on the element in left nav
      | setupOne     |
      | parameters   |
      | documentType |

    When Click on the element in the Dialog Content
      | editButton |

    And User sending the keys in Form Content
      | nameInput | <name> |

    And Click on the element in the Dialog Content
      | stage           |
      | studentRegistration |
      | examination         |

    And User press ESC button on keyboard

    And Click on the element in the Dialog Content
      | saveButton |

    Then Success message should be displayed


    Examples:
      | name   |
      | CanMet |

#  Scenario Outline: Delete Document
#    Given Click on the element in left nav
#      | setupOne     |
#      | parameters   |
#      | documentType |
#
#    When User delete item from Dialog
#      | <name> |
#
#    Then Success message should be displayed
#
#
#    Examples:
#      | name   |
#      | CanMet |

