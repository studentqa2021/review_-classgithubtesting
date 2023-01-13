
package com.cucumber.test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
	
				plugin={"json:target/cucumber.json"},//generate report
				features ={"src/main/resources/Automation Login.feature"},
				glue={"com.cucumber.test"}
				
				
					)
public class CucumberRunner extends AbstractTestNGCucumberTests{

		
		
		


}
