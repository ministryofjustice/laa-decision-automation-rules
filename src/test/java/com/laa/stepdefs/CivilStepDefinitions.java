package com.laa.stepdefs;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.kie.api.runtime.StatelessKieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.laa.SpringIntegrationTest;
import com.laa.model.Applicant;
import com.laa.model.Dependent;
import com.laa.model.EmployedIncome;
import com.laa.model.MeansInformation;
import com.laa.model.OtherIncome;
import com.laa.model.civil.CivilCase;
import com.laa.model.civil.CivilDecisionReport;
import com.laa.model.enums.ProceedingType;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CivilStepDefinitions  extends SpringIntegrationTest{
	
	private CivilCase civilCase;
	
	private CivilDecisionReport decisionReport;
	
	@Autowired
	@Qualifier("civilDecision")
	private StatelessKieSession kieSession;

	@Given("^a civil case$")
	public void caseWithorWithoutPassportBenefit() throws Throwable {
		this.civilCase = new CivilCase();
		
		
	}
	
	@And("^the following proceedings:")
	public void withProceedings(List<ProceedingType> procedingTypes) throws Throwable {
		
		civilCase.setProceedings(procedingTypes);
		
	}
	
	@And("^citizen is employed with following income:")
	public void citizenEmploymentIncome(List<EmployedIncome> employedincomeHistory) throws Throwable {
		
		MeansInformation means = Optional.ofNullable(civilCase.getMeansInformation()).orElse(new MeansInformation());
		Applicant applicant = Optional.ofNullable(means.getApplicant()).orElse(new Applicant());
		means.setApplicant(applicant);
		applicant.setEmployedIncomeHistory(employedincomeHistory);
		
	
	}
	
	@And("^receives the following benefits:")
	public void citizenOtherIncome(List<OtherIncome> otherincome) throws Throwable {
		
		MeansInformation means = Optional.ofNullable(civilCase.getMeansInformation()).orElse(new MeansInformation());
		Applicant applicant = Optional.ofNullable(means.getApplicant()).orElse(new Applicant());
		means.setApplicant(applicant);
		applicant.setOtherIncome(otherincome.get(0));
	}
	
	@And("^citizen has following children residing with them:")
	public void citizenHasChildrenWithThem(List<Dependent> dependents) throws Throwable {
		
		MeansInformation means = Optional.ofNullable(civilCase.getMeansInformation()).orElse(new MeansInformation());
	
		means.setDependents(dependents);
	}
	
	
	
	@When("^rule engine is executed$")
	public void executeDecisionRules() throws Throwable {
		
		this.decisionReport = new CivilDecisionReport();
		kieSession.execute(Stream.of(civilCase,decisionReport).collect(Collectors.toList()));
		
	}
	
	@Then("^check waiver is applied$")
    public void resultMustBe() throws Throwable {
		assertTrue(decisionReport.isDomesticViolenceWaiver());
    }
	
	
	

}
