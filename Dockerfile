# bulid

from eclipse-temurin:21-jdk-alpine as build
workdir /home/app

# copie des fichiers de config Gradle
copy build.gradle settings.gradle gradlew ./
copy gradle ./gradle

# copie de code source
copy src ./src

# compilation sans lancer les tests
run ./gradlew clean build -x test

# run
from eclipse-temurin:21-jre-alpine
workdir /app

# on recupere le jar
COPY --from=build /home/app/build/libs/*.jar app.jar

# port expose
expose 8080

#commande de demarrage
ENTRYPOINT ["java","-jar","app.jar"]