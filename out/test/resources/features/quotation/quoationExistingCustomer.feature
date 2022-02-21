# new feature
# Tags: optional

Feature: Quotation Template with an existing Customer

  Scenario Outline: quotation
    Given The dealer open the MilesWeb portal Dealer home page '<homePage>'
    When he login with the username as '<userName>' and the pwd '<password>'
    Then he can see the dealer home page
    When he selects a new quotation
    And he selects a vehicle '<car manufacturer>'
    And he selects a model '<model>'
    And he selects the type '<car type>'

    Examples:
      |homePage| userName  | password | car manufacturer| model| car type |
      |https://10.7.25.20:9943/TFMIT_TST/user/login.xhtml| testau1      | Amba1@2020  | Toyota | Aygo | car type |
#      | http://10.7.25.10:8080/TFMFR_TST/user/login.xhtml| testau1      | Amba1@2020  | toyota | Aygo | car type |
  quote:typelist:4:type