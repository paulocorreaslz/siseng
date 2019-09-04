FROM maven:3.5-jdk-8
expose 9092
ADD /target/siseng.jar siseng.jar
ENTRYPOINT ["java","-jar","siseng.jar"]
