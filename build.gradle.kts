plugins {
    id("java")
    id("org.springframework.boot") version "3.1.12"
    id ("io.spring.dependency-management") version "1.1.4"
}

java{
    sourceCompatibility = JavaVersion.VERSION_21
}
group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Spring Boot starters
    implementation ("org.springframework.boot:spring-boot-starter-web")
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation ("org.springframework.boot:spring-boot-starter-validation")

    // Database
    runtimeOnly ("org.postgresql:postgresql")

    // OpenAPI (Swagger)
    //implementation ("org.springdoc:springdoc-openapi-starter-webmvc-ui")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

    // Lombok
    compileOnly ("org.projectlombok:lombok")
    annotationProcessor ("org.projectlombok:lombok")

    // MapStruct
    implementation ("org.mapstruct:mapstruct:1.5.5.Final")
    annotationProcessor ("org.mapstruct:mapstruct-processor:1.5.5.Final")

    // Lombok + MapStruct binding
    annotationProcessor ("org.projectlombok:lombok-mapstruct-binding:0.2.0")

    // Development tools
    developmentOnly ("org.springframework.boot:spring-boot-devtools")

    // Testing
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
//    testImplementation ("org.springframework.boot:spring-boot-starter-data-jpa-test")
    testRuntimeOnly ("org.junit.platform:junit-platform-launcher")
}

//tasks.named('test') {
//    useJUnitPlatform()
//}
