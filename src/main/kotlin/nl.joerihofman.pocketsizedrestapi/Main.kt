package nl.joerihofman.pocketsizedrestapi

import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.slf4j.LoggerFactory

fun main() {

    val logger = LoggerFactory.getLogger("nl.joerihofman.pocketsizedrestapi.main")

    logger.info("HALLO WERELD")

    val server = embeddedServer(Netty, 8088) {
        routing {
            get("/helloworld") { call.respondText { "HELLO WORLD!" } }
        }
    }

    server.start(true)
}
