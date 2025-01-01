package com.walter.image.domain.console

import com.walter.image.domain.software.Software
import com.walter.image.dto.console.ConsoleRegisterRequest
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class Console constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val manufacturer: String,
    val releaseYear: Int,
    @OneToMany(mappedBy = "console")
    val softwareList: List<Software> = mutableListOf()
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