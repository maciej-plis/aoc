plugins {
    kotlin("jvm") version "1.9.21"
}

group = "com.matthias"
version = "1.0.0-SNAPSHOT"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation(kotlin("test"))
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useKotlinTest("1.9.21")
        }
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.register("initDay") {
    val day = properties["day"] ?: throw IllegalArgumentException("Undefined day!")

    copy {
        from("$projectDir/templates/source-template.txt")
        into("$projectDir/src/main/kotlin")
        rename { "Day${day}.kt" }
        expand("day" to day)
    }

    copy {
        from("$projectDir/templates/test-template.txt")
        into("$projectDir/src/test/kotlin")
        rename { "Day${day}Test.kt" }
        expand("day" to day)
    }

    val dayResources = File("$projectDir/src/test/resources/day-${day}").apply { mkdirs() }
    File("$dayResources/part-1-test").createNewFile()
    File("$dayResources/part-2-test").createNewFile()
    File("$dayResources/full").createNewFile()
}