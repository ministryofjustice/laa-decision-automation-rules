Feature: Test Civil case with domestic vioence proceeding
  Scenario: Client with domestic violence proceedings
    Given a civil case 
    And the following proceedings:
    														 | Non_Molestation_Order |
    														 | Occupation_Order | 
    														 | Residence_Order |
															 | Contact_Order |
    And citizen is employed with following income:
    															| pay |  incomeTax | nationalInsurance | frequency |
    															| 1000 | 200 | 50 | monthly |
    															| 1000 | 200 | 50 | monthly |
    															| 1000 | 200 | 50 | monthly |
    And receives the following benefits:
    															| incomeType |	amount | frequency |
    															| child_benefit | 400 | monthly |	
    	And  citizen has following children residing with them:
    															| name | relationToApplicant | dob |
    															| 	jon  | child_of_applicant | 01-01-2010 |											
    When  rule engine is executed
    Then check waiver is applied
    
    

  

    
