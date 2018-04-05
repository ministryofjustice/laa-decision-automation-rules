Feature: Test Civil case with domestic vioence proceeding
  Scenario: Client with domestic violence proceedings
    Given a section 8 case
    And the following proceedings:
    														 | Non_Molestation_Order |
    														 | Occupation_Order | 
    														 | Residence_Order |
															 | Contact_Order |
    And citizen is employed with following income history:
    															| pay |  incomeTax | nationalInsurance | frequency |employmentType|
    															| 1000 | 200 | 50 | monthly |non_armed_forces|
    															| 1000 | 200 | 50 | monthly |non_armed_forces|
    															| 1000 | 200 | 50 | monthly |non_armed_forces|
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
    
    
	Scenario: Citizen is an employed person also in receipt of Incapacity Benefit, domiciled in the UK, aged between 16 and 60. Single and applying for Residence and Specific Orders from the Section 8 Matter Type. 
Citzen is employed in two job and claims child benefit and received Incapcity Benefit for one of the children and Housing Benefit. Citizen has a bank account and is in rental accomodation.  
	 Given a section 8 case
    And the following proceedings:
    														 | residence_order |
															 | specific_issue_order |
    And citizen is employed with following income history:
    															| pay |  incomeTax | nationalInsurance | frequency |employmentType|
    															| 320 | 60 | 15 | monthly | non_armed_forces |
    															| 320 | 60 | 15 | monthly | non_armed_forces |
    															| 320 | 60 | 15 | monthly | non_armed_forces |
    And citizen receives the following benefits:
    															| incomeType |	amount | frequency |
    															| child_benefit | 600 | monthly |	
    															| incapacity_benefit | 500 | monthly |	
    															| carer_allowance | 400 | monthly |	
    															| housing_benefit | 450 | monthly |	

    	And citizen has following children residing with them:
    															| name | relationToApplicant | dob |
    															| 	jon  | child_of_applicant | 2008-05-01 |	
    															| 	tom  | child_of_applicant | 2009-01-01 |		
    															| 	bill  | child_of_applicant | 2010-12-31 |			
    	And 	citizen has following outgoings:
    															| outGoingType | amount | frequency |
    															| rental_accomodation	| 450 | monthly |		
    	And citizen has the follwoing capital assets:
    															| assetType | amount | 
    															| financial_bequest| 7000 |
    	And citizen has the following bank accounts:
    															| accountType | accountOwner | wagesAndBenefitsPaidhere | accountNumber |  balance |	
    															| single | applicant | true | 54678954 | 50 |
    When  rule engine is executed
    Then average employed income is 320.00
    Then other income is 1100.00
 
    
    

  

    
