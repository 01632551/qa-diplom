FROM node:18

# установка директории
WORKDIR /usr/src/app

# копируем исходный код
COPY .. .

# установка зависимостей
# символ астериск ("*") используется для того чтобы по возможности
# скопировать оба файла: package.json и package-lock.json
COPY package*.json ./

# установка зависимостей
RUN npm install

# запуск приложения
CMD [ "npm", "start" ]

# порт приложения
EXPOSE 9999