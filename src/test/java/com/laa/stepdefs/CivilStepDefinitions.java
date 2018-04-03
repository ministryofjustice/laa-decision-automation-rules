package com.laa.stepdefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.kie.api.runtime.StatelessKieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.laa.SpringIntegrationTest;
import com.laa.model.Applicant;
import com.laa.model.BankAccount;
import com.laa.model.Dependent;
import com.laa.model.EmployedIncome;
import com.laa.model.MeansInformation;
import com.laa.model.OtherIncome;
import com.laa.model.Outgoing;
import com.laa.model.Property;
import com.laa.model.civil.CivilCase;
import com.laa.model.civil.CivilDecisionReport;
import com.laa.model.enums.ProceedingType;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CivilStepDefinitions extends SpringIntegrationTest {

	private CivilCase civilCase;

	private CivilDecisionReport decisionReport;

	@Autowired
	@Qualifier("civilDecision")
	private StatelessKieSession kieSession;

	@Given("^a section 8 case$")
	public void caseWithorWithoutPassportBenefit() throws Throwable {
		this.civilCase = new CivilCase();

	}

	@And("^the following proceedings:")
	public void withProceedings(List<ProceedingType> procedingTypes) throws Throwable {

		civilCase.setProceedings(procedingTypes);

	}

	@And("^citizen is employed with following income history:")
	public void citizenEmploymentIncome(List<EmployedIncome> employedincomeHistory) throws Throwable {

		MeansInformation means = Optional.ofNullable(civilCase.getMeansInformation()).orElse(new MeansInformation());
		Applicant applicant = Optional.ofNullable(means.getApplicant()).orElse(new Applicant());
		means.setApplicant(applicant);
		this.civilCase.setMeansInformation(means);
		applicant.setEmployedIncomeHistory(employedincomeHistory);

	}

	@And("^citizen receives the following benefits:")
	public void citizenOtherIncome(List<OtherIncome> otherincome) throws Throwable {

		MeansInformation means = Optional.ofNullable(civilCase.getMeansInformation()).orElse(new MeansInformation());
		Applicant applicant = Optional.ofNullable(means.getApplicant()).orElse(new Applicant());
		means.setApplicant(applicant);
		List<OtherIncome> exitingOtherIncome = Optional.ofNullable(applicant.getOtherIncome()).orElse(new ArrayList<OtherIncome>());
		exitingOtherIncome.addAll(otherincome);
		applicant.setOtherIncome(exitingOtherIncome);
	}

	@And("^citizen has following children residing with them:")
	public void citizenHasChildrenWithThem(List<Dependent> dependents) throws Throwable {

		MeansInformation means = Optional.ofNullable(civilCase.getMeansInformation()).orElse(new MeansInformation());
		means.setDependents(dependents);
	}

	@And("^citizen has following outgoings:")
	public void citizenHasOutgoings(List<Outgoing> outgoings) throws Throwable {

		MeansInformation means = Optional.ofNullable(civilCase.getMeansInformation()).orElse(new MeansInformation());
		means.setOutgoings(outgoings);
	}

	@And("^citizen has the follwoing properties:")
	public void citizenHasFollowingProperties(List<Property> properties) throws Throwable {

		MeansInformation means = Optional.ofNullable(civilCase.getMeansInformation()).orElse(new MeansInformation());
		means.setProperties(properties);
	}

	@And("^citizen has the following bank accounts:")
	public void citizenHasFollowingBankaccounts(List<BankAccount> bankAccounts) throws Throwable {

		MeansInformation means = Optional.ofNullable(civilCase.getMeansInformation()).orElse(new MeansInformation());
		Optional.ofNullable(means.getBankAccounts()).orElse(new ArrayList<BankAccount>()).addAll(bankAccounts);
	}

	@When("^rule engine is executed$")
	public void executeDecisionRules() throws Throwable {

		this.decisionReport = new CivilDecisionReport();
		kieSession.execute(Stream.of(civilCase, decisionReport).collect(Collectors.toList()));

	}

	@Then("^check waiver is applied$")
	public void upperThresholdWaiverApplied() throws Throwable {
		assertTrue(decisionReport.isDomesticViolenceWaiver());
	}

	@Then("^average employed income is (\\d+.\\d+)$")
	public void employedIncomeValueIs(BigDecimal calculatedEmployedIncome) throws Throwable {
		assertEquals(calculatedEmployedIncome, decisionReport.getEmploymentIncome());
	}
	
	@Then("^other income is (\\d+.\\d+)$")
	public void otherIncomeIs(BigDecimal otherIncome) throws Throwable {
		assertEquals(otherIncome, decisionReport.getOtherIncome());
	}
	
	@Then("^gross income is (\\d+.\\d+)$")
	public void grossIncomeIs(BigDecimal grossIncome) throws Throwable {
		assertEquals(grossIncome, decisionReport.getGrossIncome());
	}
	
	@Then("^capital assessment is (\\d+.\\d+)$")
	public void capitalAssessmentIs(BigDecimal capitalAssessment) throws Throwable {
		assertEquals(capitalAssessment, decisionReport.getCapitalAssessment());
	}
	
	@Then("^disposable income is (\\d+.\\d+)$")
	public void disposableIncomeIs(BigDecimal disposableIncomeIs) throws Throwable {
		assertEquals(disposableIncomeIs, decisionReport.getDisposableIncome());
	}
	
	@Then("^citizen is illegible$")
	public void meansPassed() throws Throwable {
		assertTrue( decisionReport.isMeasnPassed());
	}

}
