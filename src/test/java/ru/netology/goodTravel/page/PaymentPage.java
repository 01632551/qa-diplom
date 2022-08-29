package ru.netology.goodTravel.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentPage {
    private ElementsCollection formFields = $$("div input[view=default]");

    // 0, 1 - переход на форму, 2 - отправление формы, 3 - одобрение, 4 - отклонение банком
    private ElementsCollection buttons = $$("button");

    private SelenideElement validationError = $("span.input__sub");


    public void enterPurchaseForm(int index){
        buttons.get(index).click();
    }

    void filingForm(String cardNumber, String month, String year, String owner, String code){
        formFields.get(0).setValue(cardNumber);
        formFields.get(1).setValue(month);
        formFields.get(2).setValue(year);
        formFields.get(3).setValue(owner);
        formFields.get(4).setValue(code);
        buttons.get(2).click();
    }

    public void validOperation(String cardNumber, String month, String year, String owner, String code){
        filingForm(cardNumber,month,year,owner,code);
        buttons.get(3).shouldBe(Condition.appear, Duration.ofSeconds(15));
        buttons.get(3).click();
        // both icons should be invisible
        buttons.get(3).shouldBe(Condition.disappear);
        buttons.get(4).shouldBe(Condition.hidden);
    }

    public void invalidOperation(String cardNumber, String month, String year, String owner, String code){
        filingForm(cardNumber,month,year,owner,code);
        buttons.get(4).shouldBe(Condition.appear, Duration.ofSeconds(15));
        buttons.get(4).click();
        // both icons should be invisible
        buttons.get(4).shouldBe(Condition.disappear);
        buttons.get(3).shouldBe(Condition.hidden);
    }

    public void validationError(String text, String cardNumber, String month, String year, String owner, String code){
        filingForm(cardNumber,month,year,owner,code);
        validationError.shouldHave(Condition.text(text));
    }
}
