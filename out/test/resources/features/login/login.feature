Feature: Login Dealer
  @ignore
  @gherkin
  Scenario Outline: Login dealer in Italy and France
    Given The dealer open the MilesWeb portal Dealer home page '<homePage>'
    When he login with the username as '<userName>' and the pwd '<password>'
    Examples:
      |homePage| userName  | password |
      |https://10.7.25.20:9943/TFMIT_TST/user/login.xhtml| testau1      | Amba1@2020  |