package nl.joerihofman.pocketsizedrestapi.databaseobject.drinks

import nl.joerihofman.pocketsizedrestapi.databaseobject.drinks.model.Drink

class Vodka: Drink {
    override val name: String = "Grey goose"
    override val price: Int = 40
}