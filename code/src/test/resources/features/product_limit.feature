Feature: check if we reached a product's limit after trying to buy some units of it

  Rule:
    Scenario: We sold units of a product and we reach the limit
      Given a product named Cucumber with an amount of 10 and a limit of 8
      When the client buys 3 units
      Then product limit is reached

    @focus
    Scenario: We sold units of a product and we dont reach the limit
      Given a product named Cucumber with an amount of 10 and a limit of 8
      When the client buys 1 unit
      Then product limit is  not reached