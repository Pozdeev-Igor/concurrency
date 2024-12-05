plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.7.0"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
    compileOnly("javax.servlet:javax.servlet-api:4.0.1")
    testImplementation("javax.servlet:javax.servlet-api:4.0.1")
    implementation("com.github.stephenc.jcip:jcip-annotations:1.0-1")

}

tasks.test {
    useJUnitPlatform()
}