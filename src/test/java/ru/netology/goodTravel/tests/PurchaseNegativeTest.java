package ru.netology.goodTravel.tests;

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

@Feature("Негативные сценарии покупки тура")
public class PurchaseNegativeTest {

    @BeforeEach
    public void setUp() {
        Selenide.open("http://localhost:8080");
    }

    @Story("Валидация поля 'номер карты'")
    @ParameterizedTest
    @CsvSource(value = {"5679 6547 768", "1298 7ыва плор 4441", "8706_3485 (6789) 5-98"})
    public void shouldAppearNotifWithDifInvalidValInCardNumb(String cardNumber) {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(1);
        var userInfo = PurchaseInfo.generateInfo("ru");
        paymentPage.validationError(
                "неверный формат", cardNumber, userInfo.getMonth(), userInfo.getYear(),
                userInfo.getOwner(), userInfo.getCode());
    }

    @Test
    public void shouldAppearErrNotifWithNullValInCardNumField() {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(1);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validationError("неверный формат", "",
                userInfo.getMonth(), userInfo.getYear(),
                userInfo.getOwner(), userInfo.getCode());
    }

    @Story("Валидация поля 'месяц'")
    @ParameterizedTest
    @CsvSource(value = {"8", "фы", "_3"})
    public void shouldAppearNotifWithDifInvalidValInMonth(String month) {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(0);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validationError(
                "неверный формат", cardNumber.getCardNumber(), month, userInfo.getYear(),
                userInfo.getOwner(), userInfo.getCode());
    }

    @ParameterizedTest
    @CsvSource(value = {"00", "13"})
    public void shouldAppearNotifWithDifInvalidDateOfExpMonth(String month) {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(0);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validationError(
                "Неверно указан срок действия карты", cardNumber.getCardNumber(), month, userInfo.getYear(),
                userInfo.getOwner(), userInfo.getCode());
    }

    @Test
    public void shouldAppearErrNotifWithNullValInMonthField() {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(1);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validationError("неверный формат", cardNumber.getCardNumber(),
                "", userInfo.getYear(),
                userInfo.getOwner(), userInfo.getCode());
    }

    @Test
    public void shouldAppearErrNotifWithExp1Month() {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(1);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validationError("Неверно указан срок действия карты", cardNumber.getCardNumber(),
                LocalDate.now().plusMonths(-1).format(DateTimeFormatter.ofPattern("MM")), LocalDate.now().format(DateTimeFormatter.ofPattern("yy")),
                userInfo.getOwner(), userInfo.getCode());
    }

    @Story("Валидация поля 'год'")
    @ParameterizedTest
    @CsvSource(value = {"5", "ав", "+-"})
    public void shouldAppearNotifWithDifInvalidValInYear(String year) {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(0);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validationError(
                "неверный формат", cardNumber.getCardNumber(), userInfo.getMonth(), year,
                userInfo.getOwner(), userInfo.getCode());
    }

    @Test
    public void shouldAppearNotifWithDifInvalidDateOfExpYear() {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(0);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validationError(
                "Неверно указан срок действия карты", cardNumber.getCardNumber(), LocalDate.now().plusYears(6).format(DateTimeFormatter.ofPattern("yy")), userInfo.getYear(),
                userInfo.getOwner(), userInfo.getCode());
    }

    @Test
    public void shouldAppearErrNotifWithNullValInYearField() {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(1);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validationError("неверный формат", cardNumber.getCardNumber(),
                userInfo.getMonth(), "",
                userInfo.getOwner(), userInfo.getCode());
    }

    @Test
    public void shouldAppearErrNotifWithExp1Year() {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(1);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validationError("Истёк срок действия карты", cardNumber.getCardNumber(),
                userInfo.getMonth(), LocalDate.now().plusYears(-1).format(DateTimeFormatter.ofPattern("yy")),
                userInfo.getOwner(), userInfo.getCode());
    }

    @Story("Валидация поля 'владелец'")
    @ParameterizedTest
    @CsvSource(value = {"фывапролджшгнеку", "-=+@Авдотий", "93079106"})
    public void shouldAppearNotifWithDifInvalidValInOwner(String owner) {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(0);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validationError(
                "неверный формат", cardNumber.getCardNumber(), userInfo.getMonth(), userInfo.getYear(),
                owner, userInfo.getCode());
    }

    @Test
    public void shouldAppearErrNotifWithNullValInOwnerField() {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(1);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validationError("Поле обязательно для заполнения", cardNumber.getCardNumber(),
                userInfo.getMonth(), userInfo.getYear(),
                "", userInfo.getCode());
    }

    @Story("Валидация поля 'CVV/CVC'")
    @ParameterizedTest
    @CsvSource(value = {"16", "ad4", "9-4"})
    public void shouldAppearNotifWithDifInvalidValInCVV(String code) {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(0);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validationError(
                "неверный формат", cardNumber.getCardNumber(), userInfo.getMonth(), userInfo.getYear(),
                userInfo.getOwner(), code);
    }

    @Test
    public void shouldAppearErrNotifWithNullValInCVVField() {
        var paymentPage = new PaymentPage();
        paymentPage.enterPurchaseForm(1);
        var userInfo = PurchaseInfo.generateInfo("ru");
        var cardNumber = DataHelper.getApprovedCardNumber();
        paymentPage.validationError("Поле обязательно для заполнения", cardNumber.getCardNumber(),
                userInfo.getMonth(), userInfo.getYear(),
                userInfo.getOwner(), "");
    }

    @Story("Неодобрение покупки по неизвестным данным карты")
    @Test
        public void shouldAppearErrorIconWithStrangeCardNumber() {
            var paymentPage = new PaymentPage();
            paymentPage.enterPurchaseForm(1);
            var userInfo = PurchaseInfo.generateInfo("ru");
            var cardNumber = DataHelper.getApprovedCardNumber();
            paymentPage.invalidOperation("1234 0987 4567 7654",
                    userInfo.getMonth(), userInfo.getYear(),
                    userInfo.getOwner(), userInfo.getCode());
        }
}
