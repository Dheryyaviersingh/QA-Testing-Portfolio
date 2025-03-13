Feature: This will test the mobile and desktop speed. After testing it will also send the date in the google sheet.

@pagepspeed
  Scenario: Test the website and send the data to google sheet
    Given user will open the pagespeed website.
    When user will enter his url in the pagespeed website
    Then website speed should be display and data should be moved in google sheet

