package nl.joerihofman.pocketsizedrestapi.database

import com.arangodb.ArangoDB
import com.arangodb.ArangoDBException
import com.arangodb.entity.BaseDocument
import io.ktor.http.Parameters
import org.json.JSONException
import org.json.JSONObject
import org.slf4j.LoggerFactory

class Arango {

    private val logger = LoggerFactory.getLogger(Arango::class.java)

    private val arangoDB = ArangoDB.Builder().host("localhost", 8529).build()
    private val databaseName = "test_database"
    private val collectionName = "test_collection"
    private val collection = arangoDB.db(databaseName).collection(collectionName)

    private val nameArray = arrayListOf("Joeri", "Nynke", "Koen", "Jan", "Maurits")


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
            arangoDB.db(databaseName).createCollection(collectionName)
            val collMade = "Collectie: $collectionName is gemaakt!"
            logger.info(collMade)
            return collMade
        } catch (e: ArangoDBException) {
            val collNotMade = "Collectie: $collectionName is NIET gemaakt"
            logger.error(collNotMade, e)
            return collNotMade
        }
    }

    fun makeDocument(parameters: Parameters): String {

        val key = parameters.get("key")

        println("KEY: $key")

        val document = BaseDocument()
        document.key = key
        document.addAttribute("naam", nameArray.random())

        return insertDocument(document)
    }

    fun getDocument(parameters: Parameters): String {
        val key = parameters.get("key")
        var answer = "null"

        try {
            val document =  collection.getDocument(key, BaseDocument::class.java)
            document?.let { answer = JSONObject(document.properties).toString() }
            logger.info(answer)
        } catch (e: ArangoDBException) {
            logger.error("Document niet gevonden", e)
        } catch (e: JSONException) {
            logger.error("Document kan niet worden omgezet in json ", e)
        }

        return answer
    }

    private fun insertDocument(document: BaseDocument): String {
        var key = "null"
        try {
            collection.insertDocument(document)
            key = document.key
            logger.info("Er is een document gemaakt met key ${document.key}")
        } catch (e: ArangoDBException) {
            logger.error("Document niet gemaakt", e)
        }
        return key
    }
}