import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
//import io.github.kobylynskyi.graphql.codegen.gradle.GraphQLCodegenGradleTask

plugins {
    id("org.springframework.boot") version "2.6.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
//    id ("io.github.kobylynskyi.graphql.codegen") version "5.4.0"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")

    //r2dbc
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("io.r2dbc:r2dbc-pool")
    runtimeOnly("dev.miku:r2dbc-mysql")
    runtimeOnly("mysql:mysql-connector-java")

    //graphql
    implementation ("com.graphql-java-kickstart:graphql-spring-boot-starter:6.0.1")
    runtimeOnly ("com.graphql-java-kickstart:graphiql-spring-boot-starter:6.0.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

//tasks.named<GraphQLCodegenGradleTask>("graphqlCodegen") {
//    // all config options:
//    // https://github.com/kobylynskyi/graphql-java-codegen/blob/master/docs/codegen-options.md
////    graphqlSchemaPaths = listOf("$projectDir/src/main/resources/graphql/schema.graphqls")
//    graphqlSchemas {
//        rootDir = "$projectDir/src/main/resources/graphql"
//    }
//    outputDir = File("$buildDir/generated")
//    packageName = "com.example.graphql.model"
//    customTypesMapping = mutableMapOf(Pair("EpochMillis", "java.time.LocalDateTime"))
//    customAnnotationsMapping = mutableMapOf(Pair("EpochMillis", listOf("@com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.example.json.EpochMillisScalarDeserializer.class)")))
//}
//
//// Automatically generate GraphQL code on project build:
//sourceSets {
//    getByName("main").java.srcDirs("$buildDir/generated")
//}

// Add generated sources to your project source sets:
//tasks.named<JavaCompile>("compileJava") {
//    dependsOn("graphqlCodegen")
//}