package com.walter.image.dto.console

import com.walter.image.domain.console.Console

data class ConsoleInfoResponse constructor (
    val id: Long,
    val name: String,
    val manufacturer: String,
    val releaseYear: Int,
    val releasedSoftware: Long?
) {
    companion object {
        fun of(result: Console) : ConsoleInfoResponse {
            return ConsoleInfoResponse(
                id = result.id!!,
                name = result.name,
                manufacturer = result.manufacturer,
                releaseYear = result.releaseYear,
                releasedSoftware = 0L   // TODO : Temporarily set to 0
            )
        }
    }
}
