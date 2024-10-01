package com.orangehrmlive.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/features",
		glue="com.orangehrmlive.steps",
		plugin= {"pretty","summary",
				"html:target/test-report.html",
				"json:target/cucumber.json"				
				},
		tags="@Register",
		monochrome = false,
		publish=true,
		dryRun=false
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
