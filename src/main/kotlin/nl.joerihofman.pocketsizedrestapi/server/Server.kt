package nl.joerihofman.pocketsizedrestapi.server

import io.ktor.application.call
import io.ktor.html.*
import io.ktor.request.receiveParameters
import io.ktor.response.respondFile
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

import nl.joerihofman.pocketsizedrestapi.database.Arango
import nl.joerihofman.pocketsizedrestapi.webpages.Index
import java.io.File

class Server {

    val arango = Arango()

    val cssTemplateFile = Server::class.java.classLoader.getResource("assets/css/main.css").file
    val cssFontAwesomeFile = Server::class.java.classLoader.getResource("assets/css/font-awesome.min.css").file

    val jquery = Server::class.java.classLoader.getResource("assets/js/jquery-3.3.1.min.js").file
    val jqueryDevelop = Server::class.java.classLoader.getResource("assets/js/jquery-3.3.1.js").file
    val javaScript = Server::class.java.classLoader.getResource("assets/js/main.js").file

    val server = embeddedServer(Netty, 8088) {
        routing {
            post("/make-database") { call.respondText{ arango.makeDatabase() } }
            post("/make-collection") { call.respondText { arango.makeCollection() } }
            post("/make-document") { call.respondText { arango.makeDocument(call.receiveParameters()) } }
            get("/get-document") { call.respondText { arango.getDocument(call.request.queryParameters) } }

            get("") { call.respondHtmlTemplate(Index()) { } }
            get("/helloworld") { call.respondText { "HELLO WORLD!" } }

            get("/css/main") { call.respondFile(File(cssTemplateFile)) }
            get("/css/font-awesome.min.css") { call.respondFile(File(cssFontAwesomeFile)) } //zelfde naam als bestand
            get("/js/main") { call.respondFile(File(javaScript)) }
            get("/js/jquery") { call.respondFile(File(jquery)) }
            get("/js/jquery-develop") { call.respondFile(File(jqueryDevelop)) }
        }
    }

    fun startServer() {
        server.start(true)
    }

}


