package com.cucumber.service;


import com.codeborne.selenide.SelenideElement;
import com.cucumber.exception.ElementNotCompareException;
import com.cucumber.page.MainPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MainPageService extends CommonService {

    @Autowired
    private MainPage mainPage;

    @Value("${text.maintext}")
    private String mainText;

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

    public void switchToMenuTab(String tab){
        clickElementFromList(mainPage.getElementsList(), "headerMenuTabs", tab);
    }
}

