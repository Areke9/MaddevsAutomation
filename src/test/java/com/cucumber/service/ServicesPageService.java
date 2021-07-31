package com.cucumber.service;

import com.cucumber.exception.ElementNotCompareException;
import com.cucumber.page.ServicePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServicesPageService extends CommonService {

    @Autowired
    private ServicePage servicePage;

    @Value("${text.fullName}")
    private String fullName;
    @Value("${text.workEmail}")
    private String workEmail;
    @Value("${text.phoneNumber}")
    private String phoneNumber;
    @Value("${text.projectDescription}")
    private String projectDescription;
    @Value("${text.teamSize}")
    private String teamSize;
    @Value("${text.privacyPolicy}")
    private String privacyPolicy;
    @Value("${text.expertise}")
    private String expertise;

    public void requestService(String service) {
        clickElementFromList(servicePage.getElementsList(), "servicesList", service);
    }

    public void fillSendForm(String form){

        switch (form){
            case "Teams":
                fillSendTeamService();
                break;

            case "Individuals":
                fillSendIndividualService();
                break;
        }
    }

    public void getSuccessMessage(String message){
        String successMessage = getText(servicePage, "successMessage");

        if(successMessage.contains(message)){
            //Тестовая проверка в IDE
            System.out.println("Message: " + successMessage);
        }
        else {
            throw new ElementNotCompareException();
        }
    }

    private void fillSendTeamService(){
        isElementDisplayed(servicePage, "serviceTeamFormBtn");
        clickButton(servicePage, "serviceTeamFormBtn");
        isElementVisible(servicePage, "clientFullName");
        inputText(servicePage, "clientFullName", fullName);
        inputText(servicePage, "clientWorkEmail", workEmail);
        inputText(servicePage, "clientPhoneNumber", phoneNumber);
        inputText(servicePage, "clientProjectDesc", projectDescription);
        clickElementFromList(servicePage.getElementsList(), "expectedTeamSize", teamSize);
        clickElementFromList(servicePage.getElementsList(), "agreementCheckboxes", privacyPolicy);
        scrollToElement(servicePage, "sendRequestServiceBtn");
        clickButton(servicePage, "sendRequestServiceBtn");
    }

    private void fillSendIndividualService(){
        isElementDisplayed(servicePage, "serviceIndividualFormBtn");
        clickButton(servicePage, "serviceIndividualFormBtn");
        isElementVisible(servicePage, "clientFullName");
        inputText(servicePage, "clientFullName", fullName);
        inputText(servicePage, "clientWorkEmail", workEmail);
        inputText(servicePage, "clientPhoneNumber", phoneNumber);
        inputText(servicePage, "clientProjectDesc", projectDescription);
        inputText(servicePage, "clientExpertise", expertise);
        clickElementFromList(servicePage.getElementsList(), "agreementCheckboxes", privacyPolicy);
        scrollToElement(servicePage, "sendRequestServiceBtn");
        clickButton(servicePage, "sendRequestServiceBtn");
    }
}
