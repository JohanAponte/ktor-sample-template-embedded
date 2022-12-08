package com.example

import com.example.plugins.configureRouting
import io.ktor.http.*
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*

/**
 * The entry point to our Ktor App
 * Also, this function contains the Server Configuration as Embedded Server
 */
fun main() {
    embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            gson()
        }
        module()
    }.start(wait = true)
}

/**
 * This is an extension function for Application Class.
 * It performs a routing configuration.
 */
fun Application.module() {
    configureRouting()
}
