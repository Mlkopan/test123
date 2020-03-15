package com.stepdefinition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import com.Mainframe.Screens.Test;


public class Stepdefinition extends Test {

	@Given ("^Login to Mainframe (.*) and perform operation$")
	public void Login_to_Mainframe_and_perform_operation (String host) throws Throwable
	{
		Mainframe(host);

	}
	@When ("^user performs Mainframeoperations$")
	public void user_performs_Mainframeoperations()
	{
		// Write your methods
	}
	
	@When ("^validate steps$")
	public void validate_steps()
	{
		// Write your validations
	}
}
