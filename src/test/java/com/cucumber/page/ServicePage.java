package com.cucumber.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
@Component
public class ServicePage implements Page{

    //SelenideElement
    @Value("${servicepage.serviceTeamFormBtnPath}")
    private String serviceTeamFormBtnPath;
    @Value("${servicepage.clientFullNamePath}")
    private String clientFullNamePath;
    @Value("${servicepage.clientWorkEmailPath}")
    private String clientWorkEmailPath;
    @Value("${servicepage.clientPhoneNumberPath}")
    private String clientPhoneNumberPath;
    @Value("${servicepage.clientProjectDescPath}")
    private String clientProjectDescPath;
    @Value("${servicepage.sendRequestServiceBtnPath}")
    private String sendRequestServiceBtnPath;
    @Value("${servicepage.successMessagePath}")
    private String successMessagePath;
    @Value("${servicepage.serviceIndividualFormBtnPath}")
    private String serviceIndividualFormBtnPath;
    @Value("${servicepage.clientExpertisePath}")
    private String clientExpertisePath;

    //ElementsCollection
    @Value("${servicepage.servicesListPath}")
    private String servicesListPath;
    @Value("${servicepage.expectedTeamSizePath}")
    private String expectedTeamSizePath;
    @Value("${servicepage.agreementCheckboxesPath}")
    private String agreementCheckboxesPath;

    public ServicePage(){}

    private Map<String, SelenideElement> servicePageElement;
    private Map<String, ElementsCollection> servicePageElementList;

    @Override
    public Map<String, SelenideElement> getElements() {
        return servicePageElement;
    }

    @Override
    public Map<String, ElementsCollection> getElementsList() {
        return servicePageElementList;
    }

    @PostConstruct
    public void init(){

        this.servicePageElement = new HashMap<>(){{
            put("serviceTeamFormBtn", $(By.xpath(serviceTeamFormBtnPath)));
            put("clientFullName", $(By.xpath(clientFullNamePath)));
            put("clientWorkEmail", $(By.xpath(clientWorkEmailPath)));
            put("clientPhoneNumber", $(By.xpath(clientPhoneNumberPath)));
            put("clientProjectDesc", $(By.xpath(clientProjectDescPath)));
            put("sendRequestServiceBtn", $(By.xpath(sendRequestServiceBtnPath)));
            put("successMessage", $(By.xpath(successMessagePath)));
            put("serviceIndividualFormBtn", $(By.xpath(serviceIndividualFormBtnPath)));
            put("clientExpertise", $(By.xpath(clientExpertisePath)));
        }};

        this.servicePageElementList = new HashMap<>(){{
           put("servicesList", $$(By.xpath(servicesListPath)));
           put("expectedTeamSize", $$(By.xpath(expectedTeamSizePath)));
           put("agreementCheckboxes", $$(By.xpath(agreementCheckboxesPath)));
        }};
    }
}
