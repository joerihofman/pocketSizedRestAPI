package nl.joerihofman.pocketsizedrestapi.databaseobject

import nl.joerihofman.pocketsizedrestapi.databaseobject.drinks.model.Drink

data class Person(val name: String, val favoriteDrink: Drink)
