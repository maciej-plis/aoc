plugins {
    kotlin("jvm") version "2.0.20"
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
