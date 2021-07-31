Feature: Checking request for company service

  @requestToGetTeam
  Scenario: I can send request to get team
    Given check for an open website
    Then switch to menu tab 'Services'
    Then make a request for service 'Remote Tech Staff'
    Then fill and service request form 'Teams'
    And check success message 'Thanks for your'

  @requestToGetIndividuals
  Scenario: I can send request to get individual
    Given check for an open website
    Then switch to menu tab 'Services'
    Then make a request for service 'Remote Tech Staff'
    Then fill and service request form 'Individuals'
    And check success message 'Thanks for your'
