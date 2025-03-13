Feature: This will test the GTM for the site.

@gtm

  Scenario: Test the website and check if GTM is added
    Given user will open the website for GTM
    When user will check the site for GTM script
    Then the GTM script should be working.