package hu.delheves.lasius.presentation.routes

import hu.delheves.lasius.presentation.dto.FileDTO
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.fileRoutes() {
    route("/api/v1/files") {
        get {
            call.respond(HttpStatusCode.OK, listOf<FileDTO>())
        }

        get("/{id}") {
            call.respond(HttpStatusCode.OK, FileDTO(id = "1", name = "test.txt", path = "/", size = 0, lastModified = 0, syncStatus = "SYNCED"))
        }

        post {
            call.respond(HttpStatusCode.Created)
        }

        delete("/{id}") {
            call.respond(HttpStatusCode.NoContent)
        }
    }
}
