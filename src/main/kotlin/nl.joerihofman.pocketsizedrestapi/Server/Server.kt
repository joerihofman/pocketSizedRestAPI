package nl.joerihofman.pocketsizedrestapi.Server

import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import nl.joerihofman.pocketsizedrestapi.Database.Arango

class Server {

    val arango = Arango()

    val server = embeddedServer(Netty, 8088) {
        routing {
            get("/helloworld") { call.respondText { "HELLO WORLD!" } }
            post("/make-database") { call.respondText{ arango.makeDatabase() } }
            post("/make-collection") { call.respondText { arango.makeCollection() } }
            post("/make-document") { call.respondText { arango.makeDocument() } }
            get("/get-document") { arango.getDocument(); call.respondText { "OKE" } }
        }
    }

    fun startServer() {
        server.start(true)
    }

}

