# spring-data-redis examples

## Environment
```
 Framwork
 - SpringBoot 2.5.6.RELEASE
 
 Build
 - Gradle 6.9
 
 Language
 - Java11 OpneJDK11
 
 Encoding
 - UTF-8
 
 Requirements
 - Spring Data Redis 2.x binaries require JDK level 8.0 and above and Spring Framework 5.3.11 and above.
 - In terms of key-value stores, Redis 2.6.x or higher is required. Spring Data Redis is currently tested against the latest 4.0 release.
 
```

## Build & Run
```
 ./gradlew wrapper --gradle-version={version}
 ./gradlew -v
 ./gradlew clean build -xtest
```


# Reference
## Exception cases
```
Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test
```
- https://kwonnam.pe.kr/wiki/springframework/springboot/test
- 