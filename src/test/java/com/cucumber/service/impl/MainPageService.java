package com.cucumber.service.impl;


import com.codeborne.selenide.SelenideElement;
import com.cucumber.exception.ElementNotCompareException;
import com.cucumber.page.MainPage;
import com.cucumber.service.CommonService;
import com.cucumber.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MainPageService extends CommonService implements MainService {

    @Autowired
    private MainPage mainPage;

    @Value("${text.maintext}")
    private String mainText;

    @Override
    public void getMainText(){
        String mText = getText(mainPage, "mainText");
        SelenideElement accepBtn = getFromMap(mainPage.getElements(), "acceptBtn");

        if(accepBtn.isDisplayed()){
            accepBtn.click();
        }

        if(mText.contains(mainText)){
            //Тестовая проверка в IDE
            System.out.println(mText);
        } else {
            throw new ElementNotCompareException();
        }

    }

    @Override
    public void switchToMenuTab(String tab){
        clickElementFromList(mainPage.getElementsList(), "headerMenuTabs", tab);
    }
}

