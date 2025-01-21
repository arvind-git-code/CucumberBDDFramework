#taking single data in parameter
Feature: test the login page

  Background: 
    Given the user is on home page

  @parameter @smoke
  Scenario: checking for sucessful login
    When user enter username "standard_user" and password "secret_sauce"
    And click on submit button
    Then user is able login
    Then user is able to navigate home page

  #using scenario outline
  @sOutline @negativeTest
  Scenario Outline: checking for sucessful login by multiple user
    When user enter username "<username>" and password "<password>"
    And click on submit button
    Then user is able to navigate home page

    Examples: 
      | username                | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |

  # using data table
  @datatable @sanity
  Scenario: checking for sucessful login and logout by multiple user
    When user enter following credentials and try to login
      | username                | password     |
      | standard_user           | secret_sauce |
     # | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |
    Then user is able to login
