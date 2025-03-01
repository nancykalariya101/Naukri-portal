@tag
Feature: Update Resume and Update Profile on Nokri Portal 

    Background:
    Given the user is logged into the Nokri portal
    And the user is on the My Profile page

//  @resume
//  Scenario: Successfully updating the resume
   // When the user clicks on the Upload Resume button
   // And selects a valid resume file 
  //  Then the system should successfully update the resume

  @Profile 
  Scenario: Successfully updating personal information
    When  the user is on the Edit Profile page
    And clicks on the Save button
    Then the system should successfully update the profile
