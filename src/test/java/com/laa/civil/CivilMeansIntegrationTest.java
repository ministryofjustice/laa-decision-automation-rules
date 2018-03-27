package com.laa.civil;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue= {"com.laa.stepdefs"}, plugin ={"pretty" , "html:target/civil-tests"})
public class CivilMeansIntegrationTest {
	


}
