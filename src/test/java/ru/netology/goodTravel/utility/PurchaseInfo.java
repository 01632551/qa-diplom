package ru.netology.goodTravel.utility;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import ru.netology.goodTravel.data.DataHelper;

import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;



@UtilityClass
public class PurchaseInfo {

    public static DataHelper.CardInfo generateInfo(String locale) {
        Faker faker = new Faker(new Locale(locale));

        return new DataHelper.CardInfo
                (LocalDate.now().plusMonths(ThreadLocalRandom.current().nextLong( 13)).format(DateTimeFormatter.ofPattern("MM")),
                        LocalDate.now().plusYears(ThreadLocalRandom.current().nextLong(1, 6)).format(DateTimeFormatter.ofPattern("yy")),
                        faker.name().firstName() + ' ' + faker.name().lastName(),
                        Integer.toString(ThreadLocalRandom.current().nextInt(100, 1000)));
    }

    @SneakyThrows
    public static DataHelper.DBInfo creditInfo(){
        var statusSQL = "select status FROM credit_request_entity order by created desc limit 1;";
        var bankIdSQL = "select bank_id FROM credit_request_entity order by created desc limit 1;";
        var creditIdSQL = "select credit_id FROM order_entity order by created desc limit 1;";
        var runner = new QueryRunner();

        try (
                var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app",
                        "app",
                        "pass");
        ){
            return new DataHelper.DBInfo(
                    runner.query(conn, statusSQL, new ScalarHandler<>()),
                    runner.query(conn, bankIdSQL, new ScalarHandler<>()),
                    runner.query(conn, creditIdSQL, new ScalarHandler<>()));
        }
    }

    @SneakyThrows
    public static DataHelper.DBInfo paymentInfo(){
        var statusSQL = "select status FROM payment_entity order by created desc limit 1;";
        var bankIdSQL = "select transaction_id FROM payment_entity order by created desc limit 1;";
        var creditIdSQL = "select payment_id FROM order_entity order by created desc limit 1;";
        var deleteOrderData = "truncate order_entity";
        var runner = new QueryRunner();

        try (
                var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app",
                        "app",
                        "pass");
        ){
            runner.update(conn, "delete FROM payment_entity");
            return new DataHelper.DBInfo(
                    runner.query(conn, statusSQL, new ScalarHandler<>()),
                    runner.query(conn, bankIdSQL, new ScalarHandler<>()),
                    runner.query(conn, creditIdSQL, new ScalarHandler<>())
            );
        }
    }

    @SneakyThrows
    public static void deleteData(){
        var deleteCreditEntity = "truncate credit_request_entity";
        var deletePaymentEntity = "truncate payment_entity";
        var deleteOrderEntity = "truncate order_entity";
        var rn = new QueryRunner();
        try (var conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app",
                "app",
                "pass")
        ){
            rn.update(conn, deleteCreditEntity);
            rn.update(conn, deletePaymentEntity);
            rn.update(conn, deleteOrderEntity);
        }
    }
}
