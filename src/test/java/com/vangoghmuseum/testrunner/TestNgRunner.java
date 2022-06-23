package com.vangoghmuseum.testrunner;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@Test
@CucumberOptions(
		features= {"src/test/java/features"},
		glue= {"testcases"}
		)
public class TestNgRunner extends AbstractTestNGCucumberTests{
 
}
