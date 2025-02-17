package hu.delheves.lasius.presentation.routes

import hu.delheves.lasius.utils.TestBase
import hu.delheves.lasius.utils.TestUtils
import io.ktor.client.request.*
import io.ktor.http.*
import kotlin.test.Test
import kotlin.test.assertEquals

class FileRoutesTest : TestBase() {
    private val dummyToken = "dummy-token"

    @Test
    fun testGetFiles() = testWithApplication {
        client.get("/api/v1/files") {
            header(HttpHeaders.Authorization, "Bearer ${TestUtils.createTestToken()}")
        }.apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }

    @Test
    fun testGetFilesUnauthorized() = testWithApplication {
        client.get("/api/v1/files").apply {
            assertEquals(HttpStatusCode.Unauthorized, status)
        }
    }


    @Test
    fun testGetFileById() = testWithApplication {
        client.get("/api/v1/files/1") {
            header(HttpHeaders.Authorization, "Bearer ${TestUtils.createTestToken()}")
        }.apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }
}
