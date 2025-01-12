package pages;

import org.openqa.selenium.By;

public class TRPage extends BasePage {

    private By firstStoreRadioBtn;
    private By continueBtn;

    public TRPage() {
        firstStoreRadioBtn = By.xpath("//android.widget.RadioButton");
        continueBtn = By.xpath("//android.widget.Button");
    }

    public void selectFirstStore(){
        waitNclick(firstStoreRadioBtn);
        waitNclick(continueBtn);
    }


}
