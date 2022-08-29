package ru.netology.goodTravel.data;

import lombok.*;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.DriverManager;

public class DataHelper {
    // первая карта (approved) 4444444444444441
    // вторая карта (declined) 4444444444444442

    private DataHelper(){}

    // card data
    @Data
    public static class CardInfo {
        private final String month;
        private final String year;
        private final String owner;
        private final String code;
    }

    @Value
    public static class CardNumberInfo {
        private String cardNumber;
    }

    public static CardNumberInfo getApprovedCardNumber() {
        return new CardNumberInfo("4444444444444441");
    }

    public static CardNumberInfo getDeclinedCardNumber() {
        return new CardNumberInfo("4444444444444442");
    }

    // db data
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DBInfo{
        private String status;
        private String transactionId;
        private String orderId;
    }
}
