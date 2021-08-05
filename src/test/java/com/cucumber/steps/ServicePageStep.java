package com.cucumber.steps;

import com.cucumber.page.ServiceType;
import com.cucumber.service.ServiceRequestService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class ServicePageStep {

    @Autowired
    private ServiceRequestService serviceRequestService;

    @Then("make a request for service '(.*)'")
    public void requestService(String service) {
        serviceRequestService.requestService(service);
    }

    @Then("fill and service request form '(.*)'")
    public void fillAndSendForm(ServiceType form) {
        serviceRequestService.fillSendForm(form);
    }

    @And("check success message '(.*)'")
    public void checkSuccessMessage(String successMessage) {
        serviceRequestService.getSuccessMessage(successMessage);
    }
}
