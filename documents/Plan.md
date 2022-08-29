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
     10. Свернуть окно нажатием на "крестик"
     11. **ожидаемый результат:** Никаких окон возникать не должно
  
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
     10. Свернуть окно нажатием на "крести0к"
     11. **ожидаемый результат:** Никаких окон возникать не должно 
  
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
     10. Свернуть окно нажатием на "крестик"
     11. **ожидаемый результат:** Никаких окон возникать не должно 

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
     10. Свернуть окно нажатием на "крестик"
     11. **ожидаемый результат:** Никаких окон возникать не должно

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
     10. Свернуть окно нажатием на "крестик"
     11. **ожидаемый результат:** Никаких окон возникать не должно
  
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
     10. Свернуть окно нажатием на "крестик"
     11. **ожидаемый результат:** Никаких окон возникать не должно

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
     10. Свернуть окно нажатием на "крестик"
     11. **ожидаемый результат:** Никаких окон возникать не должно

  8. Одобрение покупки по первой карте
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4441"
     4. В поле "месяц" ввести значение "08"
     5. В поле "год" ввести значение "23" (от 07.2022)
     6. В поле "Владелец" ввести значение "Воронова Ирина"
     7. В поле "CVC/CVV" ввести значение "103"
     8. Нажать кнопку "продолжить"
     9. Дождаться окошка "успешно! Операция одобрена банком"
     10. Свернуть окно нажатием на "крестик"
     11. **ожидаемый результат:** Никаких окон возникать не должно

  9. Одобрение покупки по второй карте
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4442"
     4. В поле "месяц" ввести значение "08"
     5. В поле "год" ввести значение "25" (от 07.2022)
     6. В поле "Владелец" ввести значение "Леонид Кропотненский"
     7. В поле "CVC/CVV" ввести значение "104"
     8. Нажать кнопку "продолжить"
     9. Дождаться окошка "успешно! Операция одобрена банком"
     10. Свернуть окно нажатием на "крестик"
     11. **ожидаемый результат:** Никаких окон возникать не должно
   
  10. Соответствие записи способа покупки в таблице order_entity при покупке тура не в кредит
      1. Перейти на страницу сервиса (http://localhost:8080)
      2. Нажать на кнопку "Купить"
      3. В поле "номер карты" ввести значение "4444 4444 4444 4441"
      4. В поле "месяц" ввести значение "02"
      5. В поле "год" ввести значение "27" (от 07.2022)
      6. В поле "Владелец" ввести значение "Тимофей Игорев"
      7. В поле "CVC/CVV" ввести значение "105"
      8. Нажать кнопку "продолжить"
      9. Дождаться окошка "успешно! Операция одобрена банком"
      10. Свернуть окно нажатием на "крестик"
      11. **ожидаемый результат:** Никаких окон возникать не должно
      
  11. Соответствие записи способа покупки в таблице order_entity при покупке в кредит
      1. Перейти на страницу сервиса (http://localhost:8080)
      2. Нажать на кнопку "Купить в кредит"
      3. В поле "номер карты" ввести значение "4444 4444 4444 4441"
      4. В поле "месяц" ввести значение "07"
      5. В поле "год" ввести значение "23" (от 07.2022)
      6. В поле "Владелец" ввести значение "Сергей По"
      7. В поле "CVC/CVV" ввести значение "106"
      8. Нажать кнопку "продолжить"
      9. Дождаться окошка "успешно! Операция одобрена банком"
      10. Свернуть окно нажатием на "крестик"
      11. **ожидаемый результат:** Никаких окон возникать не должно
  
* Негативные проверки
  1. Негативный сценарий функции покупки тура с различным значением поля "номер карты"
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить"
     3. В поле "номер карты" ввести значение "", "5679 6547 768", "1298 7ыва плор 4441", "8706_3485 (6789) 5-98"
     4. В поле "месяц" ввести значение "09"
     5. В поле "год" ввести значение "25" (от 07.2022)
     6. В поле "Владелец" ввести значение "Абликин Михаил",
     7. В поле "CVC/CVV" ввести значение "110"
     8. Нажать кнопку "продолжить"
     9. **ожидаемый результат:** Должна возникнуть ошибка на клиенте "неверный формат" под полем "номер карты" при неполном заполнении, спецсимволы и буквы не должны вводиться в поле

  2. Негативный сценарий функции покупки тура с неверным форматом значения поля "месяц"
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4441"
     4. В поле "месяц" ввести значение "", "8", "00", "13", "фы", "_3"
     5. В поле "год" ввести значение "25" (от 07.2022)
     6. В поле "Владелец" ввести значение "Суханова Евгения",
     7. В поле "CVC/CVV" ввести значение "111"
     8. Нажать кнопку "продолжить"
     9. **ожидаемый результат:** Должна возникнуть ошибка "неверный формат" на клиенте под полем "месяц", буквы и спецсимволы в поле вводиться не должны
    
  3. Негативный сценарий функции покупки тура с истёкшим сроком значения поля "месяц"
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4441"
     4. В поле "месяц" ввести значение "06", "01"
     5. В поле "год" ввести значение "22" (от 07.2022)
     6. В поле "Владелец" ввести значение "Шарикова Анастасия",
     7. В поле "CVC/CVV" ввести значение "112"
     8. Нажать кнопку "продолжить"
     9. **ожидаемый результат:** Должна возникнуть ошибка "Неверно указан срок действия карты" на клиенте под полем "месяц"

  4. Негативный сценарий функции покупки тура с неверным форматом значения поля "год"
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4441"
     4. В поле "месяц" ввести значение "05"
     5. В поле "год" ввести значение "", "5" (вместо "25"), "ав", "+-", "28", "29" (от 07.2022)
     6. В поле "Владелец" ввести значение "Шибеко Александр",
     7. В поле "CVC/CVV" ввести значение "113"
     8. Нажать кнопку "продолжить"
     9. **ожидаемый результат:** Должна возникнуть ошибка "неверно указан срок действия карты" на клиенте под полем "год", спецсимволы и буквы вводиться не должны

  5. Негативный сценарий функции покупки тура с неверным сроком окончания действия карты в поле "год"
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4442"
     4. В поле "месяц" ввести значение "10"
     5. В поле "год" ввести значение "20", "21" (от 07.2022)
     6. В поле "Владелец" ввести значение "Назарян Константин",
     7. В поле "CVC/CVV" ввести значение "114"
     8. Нажать кнопку "продолжить"
     9. **ожидаемый результат:** Должна возникнуть ошибка "срок действия карты истёк" на клиенте под полем "год"

  6. Негативный сценарий функции покупки тура с неверным форматом значения в поле "владелец"
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4441"
     4. В поле "месяц" ввести значение "04"
     5. В поле "год" ввести значение "26" (от 07.2022)
     6. В поле "Владелец" ввести значение "", "фывапролджшгнеку", "-=+@Авдотий", "93079106"
     7. В поле "CVC/CVV" ввести значение "115"
     8. Нажать кнопку "продолжить"
     9. **ожидаемый результат:** Должна возникнуть ошибка "неверный формат" на клиенте под полем "владелец", при отсутствии значения должна возникать ошибка "Поле обязательно для заполнения"

  7. Негативный сценарий функции покупки тура с неверным указанием значения в поле "CVC/CVV"
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить"
     3. В поле "номер карты" ввести значение "4444 4444 4444 4442"
     4. В поле "месяц" ввести значение "10"
     5. В поле "год" ввести значение "23" (от 07.2022)
     6. В поле "Владелец" ввести значение "Пушкин Владислав",
     7. В поле "CVC/CVV" ввести значение "", "16", "ad4", "9-4"
     8. Нажать кнопку "продолжить"
     9. **ожидаемый результат:** Должна возникнуть ошибка "неверный формат" на клиенте под полем "CVC/CVV", спецсимволы и буквы вводиться в поле не должны
     
  8. Попытка покупки тура с неизвестной карты
     1. Перейти на страницу сервиса (http://localhost:8080)
     2. Нажать на кнопку "Купить"
     3. В поле "номер карты" ввести значение "1234 0987 4567 7654"
     4. В поле "месяц" ввести значение "10"
     5. В поле "год" ввести значение "23" (от 07.2022)
     6. В поле "Владелец" ввести значение "Обулахов Захар",
     7. В поле "CVC/CVV" ввести значение "117"
     8. Нажать кнопку "продолжить"
     9. Дождаться возникновения окна с ошибкой "Ошибка! Банк отказал в проведении операции"
     10. Свернуть окно с ошибкой нажатием на "крестик"
     11. **ожидаемый результат:** После этого никаких окон возникать не должно
     
     
# Перечень используемых инструментов:
1. JUnit5 как тестовый фреймворк
2. Selenide для взаимодействия со страницей в браузере
3. Faker для генерации тестовых данных
4. Lombok для использования его в dataHelper'ах (аннотации "value" и пр.)
5. JDBC, DBUtils для взаимодействия с БД
6. Allure как сборщик отчётов
7. ThreadRandom для генерации случайного CVV/CVC кода

# Перечень и описание возможных рисков при автоматизации:
1. Т.к. это тестирование UI, есть риски неправдивости некоторых тестов. Из-за того что могут быть какие-то проблемы с подключением, интернетом, некоторые тесты могут ложно падать.
2. Новые релизы и версии могут достаточно часто выходить, из-за чего есть вероятно, что тесты быстро устареют. На их поддержку требуются ресурсы, так же может возникать проблема ложных падений.
3. Может быть не совсем корректная проверка из-за того, что не будет проводиться проверка с настоящими данными
4. В системе есть БД, так же не представлена информация по работе с ней приложений. Могут возникнуть проблемы со взаимодействием с БД

# Интервальная оценка с учётом рисков (в часах)
* 20 часов 

# План сдачи работ
* Автотесты планируется выполнить в течение 6-ти дней после принятия плана
* Результаты их прогона и отчёт по автоматизации в течение 5-ти дней после окончания работы над автотестами 