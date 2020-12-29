Feature: User story_6  Manager and sales manager  should be able to access to Vehicle cost page.


  @test1
  Scenario Outline: authorized user access to Vehicle odometer page.
    Given User is on the login page
    When User enters correct "<username>" and "<password>"
    Then User "<username>" should hoverOver Fleet "Fleet" menu and click Vehicle Costs"Vehicle Costs"
    Then User should access to vehicleCost page


    Then User should be able to create Vehicle cost
    Then User should click the save and close button
    Then User should be able to delete the Vehicle costs


############## for editting steps are repeating ###################
    Then User "<username>" should hoverOver Fleet "Fleet" menu and click Vehicle Costs"Vehicle Costs"
    Then User should access to vehicleCost page
    Then User should be able to create Vehicle cost
    Then User should click the save and close button

    Then User should be able to edit the Vehicle costs


############### for cancelling steps are repeating ###################
    Then User "<username>" should hoverOver Fleet "Fleet" menu and click Vehicle Costs"Vehicle Costs"
    Then User should access to vehicleCost page
    Then User should be able to create Vehicle cost

    Then User should be able to cancel Vehicle Cost


############### for more action steps are repeating ###################
    Then User "<username>" should hoverOver Fleet "Fleet" menu and click Vehicle Costs"Vehicle Costs"
    Then User should access to vehicleCost page
    Then User should be able to create Vehicle cost
    Then User should click the save and close button
    Then User should click the more action button
    Then User should click the Add Attachment choice




    Examples:
      | username       | password    |
      | storemanager75 | UserUser123 |
      | storemanager76 | UserUser123 |
#      | salesmanager138 | UserUser123|
#      | salesmanager139 | UserUser123|





