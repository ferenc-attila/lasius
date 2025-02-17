package hu.delheves.lasius

import hu.delheves.lasius.presentation.middleware.configureAuth
import hu.delheves.lasius.presentation.routes.authRoutes
import hu.delheves.lasius.presentation.routes.fileRoutes
import hu.delheves.lasius.presentation.routes.syncRoutes
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json


fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
            prettyPrint = true
        })
    }

    configureSecurity()
    configureSerialization()
    configureHTTP()
    configureSockets()
    configureAdministration()
    configureMonitoring()
    configureRouting()
    configureSerialization()
    configureAuth()

    routing {
        authRoutes()
        authenticate {
            fileRoutes()
            syncRoutes()
        }
    }
}
