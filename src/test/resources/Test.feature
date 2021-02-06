Feature: Test a Web application

 Scenario Outline: Automate a Web Application
    Given User launch browser
    When User enter "url"
    Then User see "SafetyPopup"
    When User click on "Advanced"
    And User click on "ClickToProceed"
    Then User see "authenticationAlertPopup"
    When User moves to "alertPopup"
    And User enter "Username"
    And User enter "Password"
    And User click on "signIn"
    Then User see "Homescreen"
    When User moves to "element" in list and select
    Then User see "enterDetailsScreen"
    When User enter "groupName"
    And User enter "displayName"
    And User enter "description"
    And User drag and drop "<tagValue>" from "source" to "tagField"
    Then Value pulled is displayed

    Examples:
        |tagValue|
        |somevalue|

