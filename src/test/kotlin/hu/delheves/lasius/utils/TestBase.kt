package hu.delheves.lasius.utils

import io.ktor.server.testing.testApplication
import io.ktor.server.testing.ApplicationTestBuilder

import hu.delheves.lasius.module

open class TestBase {

    fun <R> testWithApplication(test: suspend ApplicationTestBuilder.() -> R) = testApplication {
        application {
            module()
        }
        test()
    }
}