Feature: Bread

  Scenario: Bake some bread
    Given the following ingredients:
      | flour | 1000 |
      | water | 600  |
      | salt  | 20   |
      | yeast | 10   |
    When I mix the ingredients into a dough And I shape the dough into 2 loaves
    And I bake the loaves in the oven for 25 minutes
    Then I should have 2 delicious loaves of bread