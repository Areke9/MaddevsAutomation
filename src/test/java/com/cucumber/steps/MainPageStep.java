package com.cucumber.steps;

import com.cucumber.service.MainService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;


public class MainPageStep {

    @Autowired
    private MainService mainService;

    @Given("check for an open website")
    public void inputTextInToSearchField() {
        mainService.getMainText();
    }

    @Then("switch to menu tab '(.*)'")
    public void switchToTab(String tab){
        mainService.switchToMenuTab(tab);
    }
}
