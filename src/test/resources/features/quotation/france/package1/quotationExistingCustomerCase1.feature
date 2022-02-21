# new feature
# Tags: optional
@france
@pck1case1france # done
Feature: Create an quote with an existing customer -company

  Scenario Outline: quotation
    Given The dealer has opened the MilesWeb backoffice '<country>'
    And he logs in
    Then he can see the dealer home page
    When he selects a new quotation
    And he selects a vehicle '<car manufacturer>'
    And he selects a model '<model>'
    And he selects the type '<car type>' and the type of doors '<typeOfDoors>'
    And he goes to the next page
    And he selects the option pack '<optionPack>'
    And he chooses color '<color>' and upholstery '<upholstery>'
    And he goes to the next page
    Then he searches the customer by name '<customer Name>'
    And he selects the customer as 'Organization'
    And he goes to the next page
    Then he accepts the prospect agreement
    And he goes to the next page
    And he updates the duration <duration>
    And he updates the distance <distance>
    Then he calculates the quote
    And he checks the total price '<totalPrice>'
    And he saves it
    Then he sends the credit request
    And he clicks on credit request
    And he submit
    And he selects the agreement
    Then he clicks on done



    Examples:
      |country| car manufacturer| model                  | car type                                        |typeOfDoors | color                   | upholstery               | optionPack             | customer Name          | duration | distance |totalPrice|
      |france | Toyota          | YARIS HYBRIDE AFFAIRES | 1.5 Hybride 116h Dynamic Business Affair (2021) |5-door      | Pure White gloss paint  |Mabillon fabric upholstery| Pack Chrome            | ALT S                  | 48       | 80000    |€ 400,46  |
