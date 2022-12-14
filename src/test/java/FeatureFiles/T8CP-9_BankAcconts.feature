Feature: Bank Accounts Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario Outline: Add Bank Account
    And Click on the element in left nav
      | setupOne     |
      | parameters   |
      | bankAccounts |

    And Click on the element in the Dialog Content
      | addButton |

    And User sending the keys in Dialog Content
      | nameInput          | <name> |
      | IBAN               | <iban> |
      | iCodeInBankAccount | <code> |

    And Click on the element in the Dialog Content
      | currency   |
      | TRY        |
      | saveButton |

    Then Success message should be displayed

    Examples:
      | name   | iban        | code |
      | metcan | TR123456789 | 1234 |

  Scenario Outline: Edit Bank Account
    And Click on the element in left nav
      | setupOne     |
      | parameters   |
      | bankAccounts |

    When User Edit The "<name>" "<nameInput>"

    And User sending the keys in Dialog Content
      | IBAN               | <iban> |
      | iCodeInBankAccount | <code> |

    And Click on the element in the Dialog Content
      | saveButton |

    Then Success message should be displayed

    Examples:
      | name   | nameInput | iban        | code |
      | MetCan | CanMet    | TR987654321 | 4321 |

  Scenario: Delete Bank Account
    And Click on the element in left nav
      | setupOne     |
      | parameters   |
      | bankAccounts |

    When User delete item from Dialog
      | CanMet |

    Then Success message should be displayed

