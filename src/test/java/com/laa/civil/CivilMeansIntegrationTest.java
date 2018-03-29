package com.laa.civil;

import org.junit.runner.RunWith;

import com.laa.stepdefs.LocalDateConverter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamConverter;
import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamConverters;


@XStreamConverters(@XStreamConverter(LocalDateConverter.class))
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue= {"com.laa.stepdefs"}, plugin ={"pretty" , "html:target/civil-tests"})
public class CivilMeansIntegrationTest {
	


}
