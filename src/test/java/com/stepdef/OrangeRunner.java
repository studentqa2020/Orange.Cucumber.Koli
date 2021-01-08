package com.stepdef;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

  features = "./OrangeFeature/New.feature", //feature location 
  glue = {"./stepdef/StepDefinitaion.java"}, //step def code location 
  plugin = {"pretty",  "html:target/html report/cucumber-pretty", "json:target"}, //for report
  dryRun = false, // check the feature files written correctly or not
  //monochrome = true, // read the console easily or removed 
  //strict = true, //  Check all feature steps are correctly corresponding 
  tags= ("./generic/OrangeLogIn.java")		//type of test will run
		)


public class OrangeRunner {

	public static void main(String[] args) {
		
		
		

	}

}
