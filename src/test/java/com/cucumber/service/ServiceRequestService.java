package com.cucumber.service;

import com.cucumber.page.ServiceType;

public interface ServiceRequestService {
    void requestService(String service);
    void fillSendForm(ServiceType serviceType);
    void getSuccessMessage(String message);
}
