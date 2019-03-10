package nl.joerihofman.pocketsizedrestapi.database

import nl.joerihofman.pocketsizedrestapi.databaseobject.Person
import nl.joerihofman.pocketsizedrestapi.databaseobject.drinks.*
import org.slf4j.LoggerFactory

class ArangoGraph {

    private val logger = LoggerFactory.getLogger(ArangoGraph::class.java)

    private val databaseName = "test_database"
    private val collectionName = "test_collection"

    val arango = ArangoSettings(databaseName, collectionName)

    private val nameArray = arrayListOf("Joeri", "Nynke", "Koen", "Jan", "Maurits")
    private val drinkArray = arrayListOf(Gin(), Whisky(), Vodka(), Liqueur(), Rum())

    fun makePerson() {
        val person = Person(nameArray.random(), drinkArray.random())

        logger.info("Person: $person")
    }
}