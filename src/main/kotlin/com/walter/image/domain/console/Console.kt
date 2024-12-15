package com.walter.image.domain.console

import com.walter.image.dto.console.ConsoleRegisterRequest
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Console constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val manufacturer: String,
    val releaseYear: Int
) {
    companion object {
        fun from(request: ConsoleRegisterRequest): Console {
            return Console(
                name = request.name,
                manufacturer = request.manufacturer,
                releaseYear = request.releaseYear,
            )
        }
    }
}