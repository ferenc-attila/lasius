package hu.delheves.lasius.presentation.routes

import hu.delheves.lasius.utils.TestBase
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AuthRoutesTest : TestBase() {

    @Test
    fun testLoginWithValidCredentials() = testWithApplication {
        client.post("/api/v1/auth/login") {
            contentType(ContentType.Application.Json)
            setBody("""{"username": "testuser", "password": "password"}""")
        }.apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }

    @Test
    fun testLoginWithInvalidJson() = testWithApplication {
        client.post("/api/v1/auth/login") {
            contentType(ContentType.Application.Json)
            setBody("invalid json")
        }.apply {
            println("Response status: $status")
            println("Response body: ${bodyAsText()}")
            assertEquals(HttpStatusCode.BadRequest, status)
            val responseText = bodyAsText()

            assertTrue(responseText.startsWith("400:"))
        }
    }
}
