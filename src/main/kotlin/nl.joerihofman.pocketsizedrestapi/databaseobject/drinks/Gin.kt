package nl.joerihofman.pocketsizedrestapi.databaseobject.drinks

import nl.joerihofman.pocketsizedrestapi.databaseobject.drinks.model.Drink

class Gin: Drink {
    override val name: String = "Bobby's dry gin"
    override val price: Int = 33
}