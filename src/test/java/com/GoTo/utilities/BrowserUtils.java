package com.GoTo.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    public static List<String> getElementsText(List<WebElement> list) throws InterruptedException {
        List<String> elemTexts = new ArrayList<>();
        for (int i=0; i<list.size();i++) {
            elemTexts.add(list.get(i).getText());
            Thread.sleep(500);
        }
        return elemTexts;
    }
}
