package com.cucumber.steps;

import com.cucumber.service.MainPageService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;


public class MainPageStep {

    @Autowired
    private MainPageService mainPageService;

    @Given("check for an open website")
    public void inputTextInToSearchField() {
        mainPageService.getMainText();
    }

    @Then("switch to menu tab '(.*)'")
    public void switchToTab(String tab){
        mainPageService.switchToMenuTab(tab);
    }
}
