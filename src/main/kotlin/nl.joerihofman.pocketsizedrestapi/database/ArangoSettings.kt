package nl.joerihofman.pocketsizedrestapi.database

import com.arangodb.ArangoDB

data class ArangoSettings(val databaseName: String, val collectionName: String) {
    val arangoDB = ArangoDB.Builder().host("localhost", 8529).build()
    val collection = arangoDB.db(databaseName).collection(collectionName)
}