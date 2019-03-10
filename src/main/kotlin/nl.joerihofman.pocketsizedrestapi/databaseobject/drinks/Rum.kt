package nl.joerihofman.pocketsizedrestapi.databaseobject.drinks

import nl.joerihofman.pocketsizedrestapi.databaseobject.drinks.model.Drink

class Rum: Drink {
    override val name: String = "Brugal"
    override val price: Int = 25
}