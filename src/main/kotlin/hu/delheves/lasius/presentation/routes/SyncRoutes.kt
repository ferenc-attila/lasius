package hu.delheves.lasius.presentation.routes

import hu.delheves.lasius.presentation.dto.SyncConfigDTO
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.syncRoutes() {
    route("/api/v1/sync") {
        get("/config") {
            call.respond(HttpStatusCode.OK, listOf<SyncConfigDTO>())
        }

        post("/config") {
            val config = call.receive<SyncConfigDTO>()
            call.respond(HttpStatusCode.Created, config)
        }

        put("/config/{id}") {
            call.respond(HttpStatusCode.OK)
        }

        post("/start") {
            call.respond(HttpStatusCode.OK)
        }

        post("/stop") {
            call.respond(HttpStatusCode.OK)
        }
    }
}