package nl.joerihofman.pocketsizedrestapi.databaseobject.drinks

import nl.joerihofman.pocketsizedrestapi.databaseobject.drinks.model.Drink

class Whisky: Drink {
    override val name: String = "Lagavulin 16"
    override val price: Int = 60
}