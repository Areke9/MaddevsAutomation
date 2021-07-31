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
public class MainPage implements Page {

    //SelenideElement
    @Value("${mainpage.maintextPath}")
    private String maintextPath;
    @Value("${mainpage.acceptBtnPath}")
    private String acceptBtnPath;

    //ElementsCollection
    @Value("${mainpage.headerMenuTabsPath}")
    private String headerMenuTabsPath;

    public MainPage(){}

    private Map<String, SelenideElement> mainPageElement;
    private Map<String, ElementsCollection> mainPageElementList;

    @Override
    public Map<String, SelenideElement> getElements() {
        return mainPageElement;
    }

    @Override
    public Map<String, ElementsCollection> getElementsList() {
        return mainPageElementList;
    }

    @PostConstruct
    public void init(){
        this.mainPageElement = new HashMap<>(){{
            put("mainText", $(By.xpath(maintextPath)));
            put("acceptBtn", $(By.xpath(acceptBtnPath)));
        }};

        this.mainPageElementList = new HashMap<>(){{
            put("headerMenuTabs", $$(By.xpath(headerMenuTabsPath)));
        }};
    }
}
