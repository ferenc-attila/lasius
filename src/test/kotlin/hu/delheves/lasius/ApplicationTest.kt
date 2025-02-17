package hu.delheves.lasius

import hu.delheves.lasius.utils.TestBase
import io.ktor.client.request.*
import io.ktor.http.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest : TestBase() {

    @Test
    fun testRoot() = testWithApplication {
        client.get("/").apply {
            assertEquals(HttpStatusCode.Companion.OK, status)
        }
    }
}
