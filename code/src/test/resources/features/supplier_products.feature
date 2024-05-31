Feature: Obtain all the products made by a supplier


  Scenario:
    Given a supplier named Hacendado with id 1
    And products associated to Hacendado
      |name    |supplierId|
      |Cucumber|1         |
      |Pizza   |1         |
    When the client search for Hacendado products
    Then the following products are returned
      |name    |
      |Cucumber|
      |Pizza   |