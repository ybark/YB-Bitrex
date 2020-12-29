Feature: Login
  As a user, I want to be able to access  with username and password

  #Background: Truck driver is on the vyTrack login page


#  #@test
#  Scenario: Login  with correct credentials and verify by the name
#    Given User is on the login page
#    When User enters correct credentials
#    Then User name should be displayed

  #@test
  Scenario Outline: Login  with correct credentials and verify by the name
    Given User is on the login page
    When User enters correct username "<username>" and password "<password>"
    Then "<name>" should be displayed

    Examples:

      | username        | password    | name                 |
      | user36          | UserUser123 | Palma Balistreri     |
      | user37          | UserUser123 | Ayden Anderson       |
      | user38          | UserUser123 | Selina Walter        |
      | storemanager75  | UserUser123 | Regan Brown          |
      | storemanager76  | UserUser123 | Herminio Greenfelder |
      | salesmanager137 | UserUser123 | Buck Howe            |
      | salesmanager138 | UserUser123 | Evert Rau            |
      | salesmanager139 | UserUser123 | Clark Kilback        |

  #@test
  Scenario Outline: Login  with incorrect credentials and verify by the message
    Given User is on the login page
    When User enters incorrect "<username>" and "<password>"
    Then message "<message>" should be displayed

    Examples:

      | username        | password     | message                        |
      | user36          | UserUser1231 | Invalid user name or password. |
      | user37          | UserUser1231 | Invalid user name or password. |
      | user38          | UserUser1231 | Invalid user name or password. |
      | storemanager75  | UserUser1231 | Invalid user name or password. |
      | storemanager76  | UserUser1231 | Invalid user name or password. |
      | salesmanager137 | UserUser1231 | Invalid user name or password. |
      | salesmanager138 | UserUser1231 | Invalid user name or password. |
      | salesmanager139 | UserUser1231 | Invalid user name or password. |