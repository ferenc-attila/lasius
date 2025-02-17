package hu.delheves.lasius.presentation.routes

import hu.delheves.lasius.utils.TestBase
import hu.delheves.lasius.utils.TestUtils
import io.ktor.client.request.*
import io.ktor.http.*
import kotlin.test.Test
import kotlin.test.assertEquals

class SyncRoutesTest : TestBase() {

    @Test
    fun testGetSyncConfigUnauthorized() = testWithApplication {
        client.get("/api/v1/sync/config").apply {
            assertEquals(HttpStatusCode.Unauthorized, status)
        }
    }

    @Test
    fun testGetSyncConfig() = testWithApplication {
        client.get("/api/v1/sync/config") {
            header(HttpHeaders.Authorization, "Bearer ${TestUtils.createTestToken()}")
        }.apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }

    @Test
    fun testCreateSyncConfigUnauthorized() = testWithApplication {
        client.post("/api/v1/sync/config").apply {
            assertEquals(HttpStatusCode.Unauthorized, status)
        }
    }

    @Test
    fun testCreateSyncConfig() = testWithApplication {
        client.post("/api/v1/sync/config") {
            header(HttpHeaders.Authorization, "Bearer ${TestUtils.createTestToken()}")
            contentType(ContentType.Application.Json)
            setBody("""
                {
                    "path": "/test",
                    "syncRule": "BIDIRECTIONAL",
                    "includePattern": "*.txt",
                    "isActive": true
                }
            """.trimIndent())
        }.apply {
            assertEquals(HttpStatusCode.Created, status)
        }
    }

    @Test
    fun testStartSync() = testWithApplication {

        client.post("/api/v1/sync/start") {
            header(HttpHeaders.Authorization, "Bearer ${TestUtils.createTestToken()}")
        }.apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }

    @Test
    fun testStartSyncUnauthorized() = testWithApplication {
        client.post("/api/v1/sync/start").apply {
            assertEquals(HttpStatusCode.Unauthorized, status)
        }
    }
}
