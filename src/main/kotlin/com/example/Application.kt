package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*

/**
 * The entry point to our Ktor App
 * Also, this function contains the Server Configuration as Embedded Server
 */
fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

/**
 * This is an extension function for Application Class.
 * It performs a routing configuration.
 */
fun Application.module() {
    configureRouting()
}
