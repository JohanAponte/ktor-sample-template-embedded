package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*

/**
 * Configuration Routing set the end-points
 */
fun Application.configureRouting() {

    // Starting point for a Ktor app:
    routing {
        get("/embedded-server") {
            call.respondText("Hello, I am writing from Embedded Engine")
        }
    }
    routing {
    }
}
