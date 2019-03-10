package nl.joerihofman.pocketsizedrestapi.databaseobject.drinks

import nl.joerihofman.pocketsizedrestapi.databaseobject.drinks.model.Drink

class Liqueur: Drink {
    override val name: String = "Fladderak"
    override val price: Int = 15
}