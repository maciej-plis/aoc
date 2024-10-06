plugins {
    kotlin("jvm") version "2.0.20"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation(kotlin("test"))
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useKotlinTest("2.0.20")
        }
    }
}

tasks.test {
    minHeapSize = "1024m"
    maxHeapSize = "2048m"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.register("initDay") {
    val year = properties["year"] ?: throw IllegalArgumentException("Missing year parameter!")
    val day = properties["day"] ?: throw IllegalArgumentException("Missing day parameter!")

    copy {
        from("$projectDir/templates/source-template.txt")
        into("$projectDir/src/main/kotlin")
        rename { "Day${day}.kt" }
        expand(
            "year" to year,
            "day" to day
        )
    }

    copy {
        from("$projectDir/templates/test-template.txt")
        into("$projectDir/src/test/kotlin")
        rename { "Day${day}Test.kt" }
        expand(
            "year" to year,
            "day" to day
        )
    }

    val dayResources = File("$projectDir/src/test/resources/$year/$day").apply { mkdirs() }
    File("$dayResources/part-1-test").createNewFile()
    File("$dayResources/part-2-test").createNewFile()
}
