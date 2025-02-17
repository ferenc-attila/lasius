package hu.delheves.lasius.presentation.routes

import hu.delheves.lasius.presentation.dto.LoginDTO
import hu.delheves.lasius.presentation.dto.TokenDTO
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.authRoutes() {
    route("/api/v1/auth") {
        post("/login") {
                val loginDto = call.receive<LoginDTO>()
                // Authentication logic will go here
                call.respond(HttpStatusCode.OK, TokenDTO("dummy-token"))
        }
    }
}
