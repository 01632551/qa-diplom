# Перечень автоматизируемых сценариев   
* Позитивные проверки
  1. Позитивный сценарий функции покупки тура с различной датой окончания срока действия карты (в текущем году) 
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить в кредит"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4441"
     4. В поле "месяц" ввести значение "07", "08"
     5. В поле "год" ввести значение "22" (от 07.2022)
     6. В поле "Владелец" ввести значение "Балашов Кирил"
     7. В поле "CVC/CVV" ввести значение "105"
     8. Нажать кнопку "продолжить"
     9. Дождаться окошка "успешно! Операция одобрена банком"
     10. В базе в таблице "credit_request_entity" в последней добавленной строчке в столбце "статус" должно быть значение "approved"
  
  2. Позитивный сценарий функции покупки тура с различной датой окончания срока действия карты (в следующем году)
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить в кредит"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4441"
     4. В поле "месяц" ввести значение "01", "02", "06", "11", "12"
     5. В поле "год" ввести значение "23" (от 07.2022)
     6. В поле "Владелец" ввести значение "Жданова Алиса"
     7. В поле "CVC/CVV" ввести значение "106"
     8. Нажать кнопку "продолжить"
     9. Дождаться окошка "успешно! Операция одобрена банком"
     10. В базе в таблице "credit_request_entity" в последней добавленной строчке в столбце "статус" должно быть значение "approved"
  
  3. Позитивный сценарий функции покупки тура с различным годом окончания срока действия карты
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить в кредит"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4441"
     4. В поле "месяц" ввести значение "05"
     5. В поле "год" ввести значение "26", "27" (от 07.2022)
     6. В поле "Владелец" ввести значение "Яковлева Ева"
     7. В поле "CVC/CVV" ввести значение "107"
     8. Нажать кнопку "продолжить"
     9. Дождаться окошка "успешно! Операция одобрена банком"
     10. В базе в таблице "credit_request_entity" в последней добавленной строчке в столбце "статус" должно быть значение "approved"

  4. Позитивный сценарий функции покупки тура с различным значением поля "владелец"
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить в кредит"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4441"
     4. В поле "месяц" ввести значение "03"
     5. В поле "год" ввести значение "24" (от 07.2022)
     6. В поле "Владелец" ввести значение "Парамонова Стефания", "Анна-Мария Ин", "Роман Сорокин-Жданкин", "Артём Летучий", "Дмитрий Лебедев", "Zhukov Stepan"
     7. В поле "CVC/CVV" ввести значение "108"
     8. Нажать кнопку "продолжить"
     9. Дождаться окошка "успешно! Операция одобрена банком"
     10. В базе в таблице "credit_request_entity" в последней добавленной строчке в столбце "статус" должно быть значение "approved"

  5. Позитивный сценарий функции покупки тура с различным значением поля "CVC/CVV"
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить в кредит"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4441"
     4. В поле "месяц" ввести значение "03"
     5. В поле "год" ввести значение "24" (от 07.2022)
     6. В поле "Владелец" ввести значение "Морозов Андрей"
     7. В поле "CVC/CVV" ввести значение "109", "000", "443", "699"
     8. Нажать кнопку "продолжить"
     9. Дождаться окошка "успешно! Операция одобрена банком"
     10. В базе в таблице "credit_request_entity" в последней добавленной строчке в столбце "статус" должно быть значение "approved"
  
  6. Одобрение кредита по данным карты
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить в кредит"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4441"
     4. В поле "месяц" ввести значение "08"
     5. В поле "год" ввести значение "25" (от 07.2022)
     6. В поле "Владелец" ввести значение "Копранов Иван"
     7. В поле "CVC/CVV" ввести значение "101"
     8. Нажать кнопку "продолжить"
     9. Дождаться окошка "успешно! Операция одобрена банком"
     10. В базе в таблице "credit_request_entity" в последней добавленной строчке в столбце "статус" должно быть значение "approved"

  7. Неодобрение кредита по данным карты
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить в кредит"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4442"
     4. В поле "месяц" ввести значение "08"
     5. В поле "год" ввести значение "25" (от 07.2022)
     6. В поле "Владелец" ввести значение "Синицын Ярослав"
     7. В поле "CVC/CVV" ввести значение "102"
     8. Нажать кнопку "продолжить"
     9. Должно высветиться окошка "ошибка! Банк отказал в проведении операции"
     10. В базе в таблице "credit_request_entity" в последней добавленной строчке в столбце "статус" должно быть значение "declined"

  8. Одобрение покупки по первой карте
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить в кредит"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4441"
     4. В поле "месяц" ввести значение "08"
     5. В поле "год" ввести значение "23" (от 07.2022)
     6. В поле "Владелец" ввести значение "Воронова Ирина"
     7. В поле "CVC/CVV" ввести значение "103"
     8. Нажать кнопку "продолжить"
     9. Дождаться окошка "успешно! Операция одобрена банком"
     10. В базе в таблице "payment_entity" в последней добавленной строчке в столбце "статус" должно быть значение "approved"

  9. Одобрение покупки по второй карте
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить в кредит"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4442"
     4. В поле "месяц" ввести значение "08"
     5. В поле "год" ввести значение "25" (от 07.2022)
     6. В поле "Владелец" ввести значение "Леонид Кропотненский"
     7. В поле "CVC/CVV" ввести значение "104"
     8. Нажать кнопку "продолжить"
     9. Дождаться окошка "успешно! Операция одобрена банком"
     10. В базе в таблице "credit_request_entity" в последней добавленной строчке в столбце "статус" должно быть значение "approved"

* Негативные проверки
  1. Негативный сценарий функции покупки тура с различным значением поля "номер карты"
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить"
     3. В поле "номер карты" ввести значение "", "5679 6547 768", "1298 7ыва плор 4441", "8706_3485 (6789) 95-98"
     4. В поле "месяц" ввести значение "09"
     5. В поле "год" ввести значение "25" (от 07.2022)
     6. В поле "Владелец" ввести значение "Абликин Михаил",
     7. В поле "CVC/CVV" ввести значение "110"
     8. Нажать кнопку "продолжить"
     9. Должна возникнуть ошибка на клиенте "неверный формат" под полем "номер карты" 

  2. Негативный сценарий функции покупки тура с неверным форматом значения поля "месяц"
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4441"
     4. В поле "месяц" ввести значение "", "8", "00", "13", "фы", "_3"
     5. В поле "год" ввести значение "25" (от 07.2022)
     6. В поле "Владелец" ввести значение "Суханова Евгения",
     7. В поле "CVC/CVV" ввести значение "111"
     8. Нажать кнопку "продолжить"
     9. Должна возникнуть ошибка "неверный формат" на клиенте под полем "месяц" 
    
  3. Негативный сценарий функции покупки тура с истёкшим сроком значения поля "месяц"
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4441"
     4. В поле "месяц" ввести значение "06", "01"
     5. В поле "год" ввести значение "22" (от 07.2022)
     6. В поле "Владелец" ввести значение "Шарикова Анастасия",
     7. В поле "CVC/CVV" ввести значение "112"
     8. Нажать кнопку "продолжить"
     9. Должна возникнуть ошибка "неверно указан срок действия карты" на клиенте под полем "месяц"

  4. Негативный сценарий функции покупки тура с неверным форматом значения поля "год"
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4441"
     4. В поле "месяц" ввести значение "05"
     5. В поле "год" ввести значение "", "5" (вместо "25"), "ав", "+-", "28", "29" (от 07.2022)
     6. В поле "Владелец" ввести значение "Шибеко Александр",
     7. В поле "CVC/CVV" ввести значение "113"
     8. Нажать кнопку "продолжить"
     9. Должна возникнуть ошибка "неверно указан срок действия карты" на клиенте под полем "год"

  5. Негативный сценарий функции покупки тура с неверным сроком окончания действия карты в поле "год"
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4442"
     4. В поле "месяц" ввести значение "10"
     5. В поле "год" ввести значение "20", "21" (от 07.2022)
     6. В поле "Владелец" ввести значение "Назарян Константин",
     7. В поле "CVC/CVV" ввести значение "114"
     8. Нажать кнопку "продолжить"
     9. Должна возникнуть ошибка "срок действия карты истёк" на клиенте под полем "год"

  6. Негативный сценарий функции покупки тура с неверным форматом значения в поле "владелец"
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4441"
     4. В поле "месяц" ввести значение "04"
     5. В поле "год" ввести значение "26" (от 07.2022)
     6. В поле "Владелец" ввести значение "", "Пётр", "фывапролджшгнеку", "-=+@Авдотий", "93079106"
     7. В поле "CVC/CVV" ввести значение "115"
     8. Нажать кнопку "продолжить"
     9. Должна возникнуть ошибка "неверный формат" на клиенте под полем "владелец"

  7. Негативный сценарий функции покупки тура с неверным указанием значения в поле "CVC/CVV"
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4442"
     4. В поле "месяц" ввести значение "10"
     5. В поле "год" ввести значение "23" (от 07.2022)
     6. В поле "Владелец" ввести значение "Пушкин Владислав",
     7. В поле "CVC/CVV" ввести значение "", "16", "ad4", "9-4"
     8. Нажать кнопку "продолжить"
     9. Должна возникнуть ошибка "неверный формат" на клиенте под полем "CVC/CVV"
     
# Перечень используемых инструментов:
1. JUnit5 как тестовый фреймворк
2. Selenide для взаимодействия со страницей в браузере
3. Faker для генерации тестовых данных
4. Lombok для использования его в dataHelper'ах (аннотации "value" и пр.)
5. JDBC для взаимодействия с БД
6. Allure как сборщик отчётов
7. Random для генерации случайной даты (MM, YY)

# Перечень и описание возможных рисков при автоматизации:
1. Т.к. это тестирование UI, есть риски неправдивости некоторых тестов. Из-за того что могут быть какие-то проблемы с подключением, интернетом, некоторые тесты могут ложно падать.
2. Новые релизы и версии могут достаточно часто выходить, из-за чего есть вероятно, что тесты быстро устареют. На их поддержку требуются ресурсы, так же может возникать проблема ложных падений.
3. Может быть не совсем корректная проверка из-за того, что не будет проводиться проверка с настоящими данными
4. В системе есть БД, так же не представлена информация по работе с ней приложений. Могут возникнуть проблемы со взаимодействием с БД

# Интервальная оценка с учётом рисков (в часах)
* 20 часов 

# План сдачи работ
* Автотесты планируется выполнить через сутки после принятия плана (12-13.07.2022)
* Результаты их прогона и отчёт по автоматизации через 2 суток после окончания автотестов (13-14.07.2022)