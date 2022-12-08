package com.example.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import org.slf4j.event.*

/**
 * Configuration Routing set the end-po
 */
fun Application.configureRouting() {

    // Starting point for a Ktor app:
    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }
    routing {
        get("/") {
            call.respondText("Hello, I am writing from Embedded Engine")
        }

        get("/users/{username}") {
            val username = call.parameters["username"]
            val header = call.request.headers["Connection"]

            if(username == "Admin".lowercase()){
                call.response.header(name = "CustomHeader", value = "Admin")
                call.respond(message = "Hello Admin", status = HttpStatusCode.OK)
            }

            call.respondText("Hello $username. Header: $header")
        }

        get("/user"){
            val name = call.request.queryParameters["name"]
            val age = call.request.queryParameters["age"]

            call.respondText("Hello my name is $name and I am $age years old!")
        }

        get("/person"){
            try {
                val person = Person(name = "Johan", age = 26)
                call.respond(message = person, status = HttpStatusCode.OK)
            }catch (e: Exception){
                call.respond(message = "${e.message}", status = HttpStatusCode.BadRequest)
            }
        }
    }
}

@Serializable
data class Person(
    val name: String,
    val age: Int
)