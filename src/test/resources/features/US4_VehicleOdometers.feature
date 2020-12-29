Feature: User story_2 Authorized should be able to access to Vehicle odometer page.


  #@test
  Scenario Outline: authorized user access to Vehicle odometer page.
    Given User is on the login page
    When User enters correct "<username>" and "<password>"
    Then User "<username>" should hoverOver Fleet "Fleet" menu and click VehicleOdometer "Vehicle Odometer"
    Then User should access to odometer page"<pageTitle>"

    Examples:

      | username | password    | pageTitle          |
      | user36   | UserUser123 | Vehicles Odometers |
      | user37   | UserUser123 | Vehicles Odometers |
      | user38   | UserUser123 | Vehicles Odometers |

  #@test
  Scenario Outline: unauthorized user can not access to Vehicle odometer page.
    Given User is on the login page
    When User enters correct "<username>" and "<password>"
    Then unAuthorised User "<username>" should hoverOver Fleet "Fleet" menu and click VehicleOdometer "Vehicle Odometer" and can not reach the page



#    Then User should hoverOver fleet menu
#    Then User should not access to odometer page

    Examples:

      | username        | password    |
      | storemanager75  | UserUser123 |
      | storemanager76  | UserUser123 |
      | salesmanager137 | UserUser123 |
      | salesmanager138 | UserUser123 |
      | salesmanager139 | UserUser123 |



