package ru.netology.goodTravel.tests;

// баги: 1. по данным второй карты возникает окошко об успешной операции, в БД отклонён (должно возникать окошко "банк отказал в проведении операции"
// 2. по данным второй карты возникает окошко об успешной операции, в БД покупка отклонена (должна быть одобрена)
// 3. остаётся ошибка "неверный формат" после некорректно введённых данных о номере карты и исправлении
// 4. нет валидации поля "владелец" на клиенте
// 5. возникает окошко "операция одобрена банком" после закрытия окошка об ошибки при некорректном вводе банковской карты

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.goodTravel.data.DataHelper;
import ru.netology.goodTravel.page.PaymentPage;
import ru.netology.goodTravel.utility.PurchaseInfo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Позитивные сценарии покупки тура")
public class PurchasePositiveTest {

    @BeforeEach
    public void setUp(){
        Selenide.open("http://localhost:8080");
        PurchaseInfo.deleteData();
    }


    @Story("Проверки на правильность записи в таблицу order-entity")
    @Test
    public void shouldBeConformityWithNoticeOfPaymentTransaction(){
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(0);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validOperation(cardNumber.getCardNumber(),
                userInfo.getMonth(), userInfo.getYear(),
                userInfo.getOwner(), userInfo.getCode());

        var dbInfo = PurchaseInfo.paymentInfo();
        assertEquals(dbInfo.getTransactionId(), dbInfo.getOrderId());
    }

    @Test
    public void shouldBeConformityWithNoticeOfCreditTransaction(){
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(1);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validOperation(cardNumber.getCardNumber(),
                userInfo.getMonth(), userInfo.getYear(),
                userInfo.getOwner(), userInfo.getCode());

        var dbInfo = PurchaseInfo.creditInfo();
        assertEquals(dbInfo.getTransactionId(), dbInfo.getOrderId());
    }


    @Story("проверка статуса покупки в зависимости от карты")
    @Test
    public void shouldApprovePaymentWithFirstCard(){
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(0);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validOperation(cardNumber.getCardNumber(),
                userInfo.getMonth(), userInfo.getYear(),
                userInfo.getOwner(), userInfo.getCode());

        var dbInfo = PurchaseInfo.paymentInfo();
        assertEquals("APPROVED", dbInfo.getStatus());
    }

    @Test
    public void shouldDeclinePaymentWithSecondCard(){
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(0);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getDeclinedCardNumber();
        paymentPage.validOperation(cardNumber.getCardNumber(),
                userInfo.getMonth(), userInfo.getYear(),
                userInfo.getOwner(), userInfo.getCode());

        var dbInfo = PurchaseInfo.paymentInfo();
        assertEquals("DECLINED", dbInfo.getStatus());
    }

    @Test
    public void shouldDeclineCreditWithSecondCard() {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(1);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getDeclinedCardNumber();
        paymentPage.validOperation(cardNumber.getCardNumber(),
                userInfo.getMonth(), userInfo.getYear(),
                userInfo.getOwner(), userInfo.getCode());

        var dbInfo = PurchaseInfo.creditInfo();
        assertEquals("DECLINED", dbInfo.getStatus());
    }

    @Test
    public void shouldApproveCreditWithFirstCard() {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(1);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validOperation(cardNumber.getCardNumber(),
                userInfo.getMonth(), userInfo.getYear(),
                userInfo.getOwner(), userInfo.getCode());

        var dbInfo = PurchaseInfo.creditInfo();
        assertEquals("APPROVED", dbInfo.getStatus());
    }


    @Story("Проверка на валидацию полей")
    @ParameterizedTest
    @CsvSource(value = {"109", "000", "443", "699"})
    public void shouldSuccessfullyBuyTourWithDifCVV(String code) {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(1);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validOperation(cardNumber.getCardNumber(),
                userInfo.getMonth(), userInfo.getYear(),
                userInfo.getOwner(), code);
    }

    @ParameterizedTest
    @CsvSource(value = {"Парамонова Стефания", "Анна-Мария Ин", "Роман Сорокин-Жданкин", "Артём Летучий", "Дмитрий Лебедев", "Zhukov Stepan"})
    public void shouldSuccessfullyBuyTourWithDifOwner(String owner) {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(1);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validOperation(cardNumber.getCardNumber(),
                userInfo.getMonth(), userInfo.getYear(),
                owner, userInfo.getCode());
    }

    @Test
    public void shouldSuccessfullyBuyTourWithDifExpired4Year() {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(1);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validOperation(cardNumber.getCardNumber(),
                userInfo.getMonth(), LocalDate.now().plusYears(4).format(DateTimeFormatter.ofPattern("yy")),
                userInfo.getOwner(), userInfo.getCode());
    }

    @Test
    public void shouldSuccessfullyBuyTourWithDifExpired5Year() {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(1);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validOperation(cardNumber.getCardNumber(),
                userInfo.getMonth(), LocalDate.now().plusYears(5).format(DateTimeFormatter.ofPattern("yy")),
                userInfo.getOwner(), userInfo.getCode());
    }

    @Test
    public void shouldSuccessfullyBuyTourWithDifExpiredCurMonth() {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(1);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validOperation(cardNumber.getCardNumber(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("MM")), LocalDate.now().format(DateTimeFormatter.ofPattern("yy")),
                userInfo.getOwner(), userInfo.getCode());
    }

    @Test
    public void shouldSuccessfullyBuyTourWithDifExpiredNextMonth() {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(1);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validOperation(cardNumber.getCardNumber(),
                LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("MM")), LocalDate.now().format(DateTimeFormatter.ofPattern("yy")),
                userInfo.getOwner(), userInfo.getCode());
    }

    @ParameterizedTest
    @CsvSource(value = {"01", "02", "06", "11", "12"})
    public void shouldSuccessfullyBuyTourWithDifExpiredMonthNextYear(String year) {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(1);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validOperation(cardNumber.getCardNumber(),
                userInfo.getMonth(), LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("yy")),
                userInfo.getOwner(), userInfo.getCode());
    }
}
