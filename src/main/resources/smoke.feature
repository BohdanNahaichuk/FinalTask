Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check visibility of site's main functions
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks footer visibility
    And User checks search field visibility
    And User checks cart visibility
    And User checks register button visibility
    Then User checks that shopping cart icon is visible

    Examples:
      | homePage                            |
      | https://www.amazon.com/             |

  Scenario Outline: Check Sign in functionality with correct credentials
    Given User opens '<homePage>' page
    When User clicks 'Sign in' button
    And User checks email field visibility on sign in page
    When User input '<valid email>' address
    And User clicks 'Continue' button
    And User checks password field visibility on sign in page
    When User input '<valid password>'
    And User clicks 'Sign-In' button
    Then User can observe greeting message

    Examples:
      | homePage                            | valid email                   | valid password |
      | https://www.amazon.com/             | ivanfederovich+test@gmail.com | password1234   |

  Scenario Outline: Check that user cannot sign in with incorrect email
    Given User opens '<homePage>' page
    When User clicks 'Sign in' button
    And User checks email field visibility on sign in page
    When User input '<invalid email>' address
    And User clicks 'Continue' button
    Then 'There was a problem' message is appear

    Examples:
      | homePage                            | invalid email  |
      | https://www.amazon.com/             | DamnWrongEmail |

  Scenario Outline: Check that user cannot sign in with incorrect password
    Given User opens '<homePage>' page
    When User clicks 'Sign in' button
    And User checks email field visibility on sign in page
    When User input '<valid email>' address
    And User clicks 'Continue' button
    And User checks password field visibility on sign in page
    When User input '<invalid password>'
    And User clicks 'Sign-In' button
    Then 'There was a problem' message is appear

      Examples:
        | homePage                            | valid email                  | invalid password  |
        | https://www.amazon.com/             | ivanfederovich+test@gmail.com| IncorrectPassword |

  Scenario Outline: Checking of the product searching and filtering
    Given User opens '<homePage>' page
    When User makes search by keyword '<product>'
    And User clicks on search button
    And Search results is displayed
    And User clicks on '$35 and Above' filter button
    And User enters '<value>' to '$max' price field filter
    When User clicks on 'steam controller' product
    Then User checks that current url contains '<product ID>'

    Examples:
      | homePage                            | product          | product ID | value |
      | https://www.amazon.com/             | steam controller | B016KBVBCS | 1000  |

  Scenario Outline: Check that 'no results' information is present with incorrect value in '$max' price field filter
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks on search button
    And Search results is displayed
    And User enters '<value>' to '$max' price field filter
    And User apply filter by clicking 'go' button
    Then User observe 'No results' message

    Examples:
      | homePage                | keyword               | value |
      | https://www.amazon.com/ | samsung 8k tv 65 inch | 1     |

  Scenario Outline: Check add product to cart functionality
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks on search button
    When User clicks on 'sony wh-1000xm3' product
    And User checks that 'Add to Cart' button is visible
    And User clicks 'Add to Cart' button on product
    And User clicks 'Cart' button
    Then User checks that cart contains '<count>' item

    Examples:
      | homePage                | keyword         | count |
      | https://www.amazon.com/ | sony wh-1000xm3 | 1     |

  Scenario Outline: Check add product to 'Add to List'
    Given User opens '<homePage>' page
    When User clicks 'Sign in' button
    When User input '<valid email>' address
    And User clicks 'Continue' button
    When User input '<valid password>'
    And User clicks 'Sign-In' button
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks on search button
    And User clicks on 'xbox one x' product
    And User clicks on 'Add to List' button
    Then Item added to Shopping List message is displayed

    Examples:
      | homePage                            | keyword       | valid email                 | valid password |
      | https://www.amazon.com/             | xbox one x    |ivanfederovich+test@gmail.com| password1234   |

  Scenario Outline: Checking delivery option functionality
    Given User opens '<homePage>' page
    And User clicks 'Deliver to' button
    And User clicks on country dropdown menu
    When User choice 'Ukraine' option in dropdown country menu
    And Confirm by clicking 'Done' button
    Then 'Ukraine' option is displayed in 'Deliver to' frame

    Examples:
      | homePage                |
      | https://www.amazon.com/ |

  Scenario Outline: Language and Currency functionality check
    Given User opens '<homePage>' page
    When User clicks language button
    And User clicks on 'Deutsch - DE' radio button
    And User clicks on currency dropdown menu
    And User clicks on '€ - EUR - Euro' option in dropdown list
    And Apply language and currency settings by clicking 'Änderungen speichern' button
    Then User checks that current url contains '<relevant Currency and Language settings>'

    Examples:
      | homePage                | relevant Currency and Language settings |
      | https://www.amazon.com/ | currency=EUR&language=de_DE             |

  Scenario Outline: Shopping address details visibility check
    Given User opens '<homePage>' page
    When User clicks 'Sign in' button
    And User checks email field visibility on sign in page
    When User input '<valid email>' address
    And User clicks 'Continue' button
    And User checks password field visibility on sign in page
    When User input '<valid password>'
    And User clicks 'Sign-In' button
    When User makes search by keyword '<keyword>'
    And User clicks on search button
    When User clicks on 'sony wh-1000xm3' product
    And User checks that 'Add to Cart' button is visible
    And User clicks 'Add to Cart' button on product
    And User clicks 'Proceed to checkout' button
    Then All necessary information fields for shipping is visible

    Examples:
      | homePage                            | valid email                   | valid password | keyword         |
      | https://www.amazon.com/             | ivanfederovich+test@gmail.com | password1234   | sony wh-1000xm3 |