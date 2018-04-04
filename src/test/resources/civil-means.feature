Feature: Test Civil case with domestic vioence proceeding
  Scenario: Client with domestic violence proceedings
    Given a section 8 case
    And the following proceedings:
    														 | Non_Molestation_Order |
    														 | Occupation_Order | 
    														 | Residence_Order |
															 | Contact_Order |
    And citizen is employed with following income history:
    															| pay |  incomeTax | nationalInsurance | frequency |
    															| 1000 | 200 | 50 | monthly |
    															| 1000 | 200 | 50 | monthly |
    															| 1000 | 200 | 50 | monthly |
    And citizen receives the following benefits:
    															| incomeType |	amount | frequency |
    															| child_benefit | 400 | monthly |	
    	And citizen has following children residing with them:
    															| name | relationToApplicant | dob |
    															| 	jon  | child_of_applicant | 2010-03-01 |		
    	And 	citizen has following outgoings:
    															| outGoingType | amount | frequency |
    															| child_care_fees | 200 | monthly|
    															| mortgage_payment	| 400 | monthly |		
    	And citizen has the follwoing properties:
    															| propertyType | ownershipType | marketValue | chargeOnProperty | mortgaged | amountInPrinciple| subjectToProceedings| ownserhipSharePct |
    															| semi_detatched| part | 200000 | 	false | true | 100000 |	false| 100 |
    	And citizen has the following bank accounts:
    															| accountType | accountOwner | wagesAndBenefitsPaidhere | accountNumber |  balance |	
    															| single | applicant | true | 12345678 | 500 |
    When  rule engine is executed
    Then check waiver is applied
    Then average employed income is 1000.00
    Then other income is 400.00
    Then gross income is 1400.00
    Then disposable income is 213.51
    Then capital assessment is 100500.0
    Then citizen is illegible
    
    

  

    
