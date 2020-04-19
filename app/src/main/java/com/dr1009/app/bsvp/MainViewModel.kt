package com.dr1009.app.bsvp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate

private val family = listOf(
    Animal(
        id = 0,
        type = Animals.Dog,
        name = "Taro",
        birthday = LocalDate.now().minusYears(3),
        memo = "He likes beef"
    ),
    Animal(
        id = 1,
        type = Animals.Dog,
        name = "Jiro",
        birthday = LocalDate.now().minusYears(2),
        memo = "He likes pork"
    ),
    Animal(
        id = 3,
        type = Animals.Cat,
        name = "Hana",
        birthday = LocalDate.now().minusYears(2),
        memo = "She likes fish"
    )
)

class MainViewModel : ViewModel() {

    private val animals = family.toMutableList()
    val animalList = MutableLiveData(animals)

}