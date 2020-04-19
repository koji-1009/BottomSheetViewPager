package com.dr1009.app.bsvp

import java.time.LocalDate

data class Animal(
    val id: Int,
    val type: Animals,
    val name: String,
    val birthday: LocalDate,
    val memo: String = "some comment"
)

enum class Animals {
    Dog, Cat
}
