package nl.joerihofman.pocketsizedrestapi.database

import com.arangodb.ArangoDB
import com.arangodb.ArangoDBException
import com.arangodb.entity.BaseDocument
import org.slf4j.LoggerFactory

class Arango {

    private val logger = LoggerFactory.getLogger(Arango::class.java)

    private val arangoDB = ArangoDB.Builder().host("localhost", 8529).build()
    private val databaseName = "test_database"
    private val collectieName = "test_collection"

    private val nameArray = arrayListOf("Joeri", "Nynke", "Koen", "Jan", "Maurits")

    private var keyInt = 0

    fun makeDatabase(): String {

        try {
            arangoDB.createDatabase(databaseName)
            val dbMade = "Database: $databaseName is gemaakt!"
            logger.info(dbMade)
            return dbMade
        } catch (e: ArangoDBException) {
            val dbNotMade = "Database $databaseName is NIET gemaakt"
            logger.error(dbNotMade, e)
            return dbNotMade
        }

    }

    fun makeCollection(): String {

        try {
            arangoDB.db(databaseName).createCollection(collectieName)
            val collMade = "Collectie: $collectieName is gemaakt!"
            logger.info(collMade)
            return collMade
        } catch (e: ArangoDBException) {
            val collNotMade = "Collectie: $collectieName is NIET gemaakt"
            logger.error(collNotMade, e)
            return collNotMade
        }
    }

    fun makeDocument(): String {

        try {
            keyInt = keyInt.inc()
            val document = BaseDocument()
            document.key = keyInt.toString()
            document.addAttribute("naam", nameArray.random())
            arangoDB.db(databaseName).collection(collectieName).insertDocument(document)
            logger.info("Er is een document gemaakt met key $keyInt")
            return keyInt.toString()
        } catch (e: ArangoDBException) {
            logger.error("Document niet gemaakt", e)
            return "-1"
        }
    }

    fun getDocument() {
        try {
            val document = arangoDB.db(databaseName).collection(collectieName).getDocument(keyInt.toString(), BaseDocument::class.java)
            logger.info("KEY : ${document.key}")
            logger.info("VAL : ${document.getAttribute("naam")}")
        } catch (e: ArangoDBException) {
            logger.error("Document niet gevonden", e)
        }
    }
}