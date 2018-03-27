package com.laa.stepdefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.kie.api.runtime.StatelessKieSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.laa.SpringIntegrationTest;
import com.laa.model.MeansInformation;
import com.laa.model.civil.CivilCase;
import com.laa.model.civil.CivilDecisionReport;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CivilStepDefinitions  extends SpringIntegrationTest{
	
	private CivilCase civilCase;
	
	private CivilDecisionReport decisionReport;
	
	@Autowired
	private StatelessKieSession kieSession;

	@Given("^a case (.*) passport benefit$")
	public void caseWithorWithoutPassportBenefit(String withOrWithout) throws Throwable {
		Boolean passportedBenefit = "with".equalsIgnoreCase(withOrWithout);
		this.civilCase  = new CivilCase();
		MeansInformation meansInformation = new MeansInformation();
		meansInformation.setPassportedBenefit(passportedBenefit);
		this.civilCase.setMeansInformation(meansInformation);
		
	}
	
	@And("^a total capital of (\\d+\\.\\d+)$")
	public void caseWithorWithoutPassportBenefit(BigDecimal totalCapital) throws Throwable {
	
		this.civilCase.getMeansInformation().setTotalIncome(totalCapital);
		
	}
	
	
	@When("^decision rules are fired$")
	public void i_am_on_the_page_on_URL() throws Throwable {
		
		this.decisionReport = new CivilDecisionReport();
		kieSession.execute(Stream.of(civilCase,decisionReport).collect(Collectors.toList()));
	}
	
	@Then("^means must be (.*)$")
    public void she_will_get_$_back(String expected) throws Throwable {
		Boolean meansDecisionExpected = "accepted".equalsIgnoreCase(expected);
        assertEquals(meansDecisionExpected,decisionReport.isMeansAccepted());
    }
	
	
	

}
