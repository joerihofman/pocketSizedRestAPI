package nl.joerihofman.pocketsizedrestapi

import nl.joerihofman.pocketsizedrestapi.Server.Server
import org.slf4j.LoggerFactory

fun main() {

    val logger = LoggerFactory.getLogger("nl.joerihofman.pocketsizedrestapi.main")

    logger.info("HALLO WERELD")

    Server().startServer()

    logger.info("Server staat aan")

}
