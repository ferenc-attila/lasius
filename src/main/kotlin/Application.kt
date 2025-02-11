package hu.delheves

import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSecurity()
    configureSerialization()
    configureHTTP()
    configureSockets()
    configureAdministration()
    //configureDatabases()
    configureMonitoring()
    configureRouting()
}
