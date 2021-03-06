Feature: Case 1 Test Civil case with domestic vioence proceeding
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
    															| propertyType | ownershipType | marketValue | chargeOnProperty | mortgaged | amountInPrinciple| subjectToProceedings| ownserhipSharePct |mainDwelling|
    															| semi_detatched| part | 200000 | 	false | true | 100000 |	false| 100 |true|
    	And citizen has the following bank accounts:
    															| accountType | accountOwner | wagesAndBenefitsPaidhere | accountNumber |  balance |	
    															| single | applicant | true | 12345678 | 500 |
    When  rule engine is executed
    Then check waiver is applied
    Then average employed income is 1000.00
    Then other income is 400.00
    Then gross income is 1400.00
    Then disposable income is 213.51
    Then capital contribution amount is 0.00
    Then citizen is eligible
    
    
	Scenario: Case 2 Citizen is an employed person also in receipt of Incapacity Benefit, domiciled in the UK, aged between 16 and 60. Single and applying for Residence and Specific Orders from the Section 8 Matter Type. 
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
    Then gross income is 1420.00
    Then disposable income is 425.53
    Then citizen is eligible
    Then income contribution amount is 40.44
    Then capital contribution amount is 4050.00
    
    
Scenario: Case 3 Citizen is an employed person, domicilied in the UK, aged between 16 and 60. Single and respondent to Non Molestation (From the Domestic Violence Matter Type) and Residence Orders (from the Section 8 Matter Type). 
Citzen is employed in two jobs and own's his own property. Citizen has a bank account.  
	 Given a section 8 case
    And the following proceedings:
    														 | non_molestation_order |
															 | residence_order |
		And the citizen involvement type is "respondent"
    And citizen is employed with following income history:
    															| pay |  incomeTax | nationalInsurance | frequency |employmentType|
    															| 2700 | 450 | 150 | monthly | non_armed_forces |
    															| 2700 | 450 | 150 | monthly | non_armed_forces |
    															| 2700 | 450 | 150 | monthly | non_armed_forces |	
    	And 	citizen has following outgoings:
    															| outGoingType | amount | frequency |
    															| maintenance	| 800 | monthly |		
    															| mortgage_payment	| 750 | monthly |		
    	And citizen has the follwoing properties:
    															| propertyType | ownershipType | marketValue | chargeOnProperty | mortgaged | amountInPrinciple| subjectToProceedings| ownserhipSharePct | mainDwelling|
    															| semi_detatched| full | 300000 | 	false | true | 150000 |	false| 100 | true|
    	And citizen has the following bank accounts:
    															| accountType | accountOwner | wagesAndBenefitsPaidhere | accountNumber |  balance |	
    															| single | applicant | true | 54678954 | 1000 |
    When  rule engine is executed
    Then average employed income is 2700.00
    Then gross income is 2700.00
    Then disposable income is 710.00
    Then citizen is ineligible

    
    
Scenario: Case 4 Citizen in Case 3 reapplies and makes a cross application for Non Molestation Order. 
	 Given a section 8 case
    And the following proceedings:
    														 | non_molestation_order |
															 | residence_order |
		And the citizen involvement type is "cross_applicant"
    And citizen is employed with following income history:
    															| pay |  incomeTax | nationalInsurance | frequency |employmentType|
    															| 2700 | 450 | 150 | monthly | non_armed_forces |
    															| 2700 | 450 | 150 | monthly | non_armed_forces |
    															| 2700 | 450 | 150 | monthly | non_armed_forces |	
    	And 	citizen has following outgoings:
    															| outGoingType | amount | frequency |
    															| maintenance	| 800 | monthly |		
    															| mortgage_payment	| 750 | monthly |		
    	And citizen has the follwoing properties:
    															| propertyType | ownershipType | marketValue | chargeOnProperty | mortgaged | amountInPrinciple| subjectToProceedings| ownserhipSharePct | mainDwelling|
    															| semi_detatched| full | 300000 | 	false | true | 150000 |	false| 100 | true|
    	And citizen has the following bank accounts:
    															| accountType | accountOwner | wagesAndBenefitsPaidhere | accountNumber |  balance |	
    															| single | applicant | true | 54678954 | 1000 |
    When  rule engine is executed
    Then average employed income is 2700.00
    Then gross income is 2700.00
    Then disposable income is 710.00
    Then income contribution amount is 169.20
    Then capital contribution amount is 89000.00
    Then citizen is eligible
    
Scenario: Case 5 Citizen is an employed person, domicilied in the UK, aged between 16 and 60. Seperated and applying for Ancilliary Relief and Residence and Contact Orders. 
Citzen is employed in one job and claims child benefit. Citizen has a bank account and owns their own home. 
	 Given a section 8 case
    And the following proceedings:
    														 |ancillary_relief|
															|contact_order|
															|residence_order|
		And the citizen involvement type is "applicant"
    And citizen is employed with following income history:
    															| pay |  incomeTax | nationalInsurance | frequency |employmentType|
    															| 1200 | 200 | 50 | monthly | non_armed_forces |
    															| 1200 | 200 | 50 | monthly | non_armed_forces |
    															| 1200 | 200 | 50 | monthly | non_armed_forces |
   And citizen has following children residing with them:
    															| name | relationToApplicant | dob |
    															| 	jon  | child_of_applicant | 2004-03-01 |		
   And citizen receives the following benefits:
    															| incomeType |	amount | frequency |
    															| child_benefit | 400 | monthly |	
    															| maintenance | 200 | monthly |	
    						
    	And 	citizen has following outgoings:
    															| outGoingType | amount | frequency |
    															| child_care_fees | 200 | monthly|	
    	And citizen has the follwoing properties:
    															| propertyType | ownershipType | marketValue | chargeOnProperty | mortgaged | amountInPrinciple| subjectToProceedings| ownserhipSharePct | mainDwelling|
    															| semi_detatched| part | 500000 | 	false | true | 150000 |	true| 50 | true|
    	And citizen has the following bank accounts:
    															| accountType | accountOwner | wagesAndBenefitsPaidhere | accountNumber |  balance |	
    															| single | applicant | true | 54678954 | 200 |
    															| single | applicant | false | 346799890 | 2500 |
    When  rule engine is executed
    Then gross income is 1800.00
    Then disposable income is 1013.51
    Then citizen is ineligible


Scenario: Case 6 Citizen is ex spouse of Case 5
	 Given a section 8 case
    And the following proceedings:
    														 |ancillary_relief|
															|contact_order|
															|residence_order|
		And the citizen involvement type is "applicant"
    And citizen is employed with following income history:
    															| pay |  incomeTax | nationalInsurance | frequency |employmentType|
    															| 2500 | 250 | 80 | monthly | non_armed_forces |
    															| 2500 | 250 | 80 | monthly | non_armed_forces |
    															| 2500 | 250 | 80 | monthly | non_armed_forces |


    						
    	And 	citizen has following outgoings:
    															| outGoingType | amount | frequency |
    															| maintenance | 200 | monthly|	
    															| rental_accomodation | 550 | monthly|	
    	And citizen has the follwoing properties:
    															| propertyType | ownershipType | marketValue | chargeOnProperty | mortgaged | amountInPrinciple| subjectToProceedings| ownserhipSharePct | mainDwelling|
    															| semi_detatched| part | 500000 | 	false | true | 150000 |	true| 50 | false|
    	And citizen has the following bank accounts:
    															| accountType | accountOwner | wagesAndBenefitsPaidhere | accountNumber |  balance |	
    															| single | applicant | true | 123688988 | 0 |
    															| single | applicant | false | 879789891 | 5000 |
    When  rule engine is executed
    Then gross income is 2500.00
    Then disposable income is 1375.00
    Then capital contribution amount is 97500.00
    Then citizen is ineligible

