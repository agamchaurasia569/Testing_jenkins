FROM selenium/standalone-chrome:latest

USER root

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY . .

CMD ["mvn","test","-DsuiteXmlFile=testng.xml"]