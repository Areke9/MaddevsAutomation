package com.cucumber.steps;

import com.cucumber.service.ServicesPageService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class ServicePageStep {

    @Autowired
    private ServicesPageService servicePageService;

    @Then("make a request for service '(.*)'")
    public void requestService(String service) {
        servicePageService.requestService(service);
    }

    @Then("fill and service request form '(.*)'")
    public void fillAndSendForm(String form) {
        servicePageService.fillSendForm(form);
    }

    @And("check success message '(.*)'")
    public void checkSuccessMessage(String successMessage) {
        servicePageService.getSuccessMessage(successMessage);
    }
}
