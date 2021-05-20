Feature: User story_1 As a truck driver user should be able to access Vehicle under Fleet module.

  Scenario Outline: authorized user access to Vehicle page.
    Given User is on the login page

    Given User is on the login page
    When User enters correct username "<username>" and password "<password>"
    Then User "<username>" should hoverOver Fleet "Fleet" menu and click Vehicles "Vehicles"
    Then User should access to vehicle page"<pageTitle>"

    Examples:

      | username | password    | pageTitle |
      | user36   | UserUser123 | All Cars  |
      | user37   | UserUser123 | All Cars  |
      | user38   | UserUser123 | All Cars  |

