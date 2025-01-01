package com.walter.image.dto.console

data class ConsoleInfoResponse constructor (
    val id: Long,
    val name: String,
    val manufacturer: String,
    val releaseYear: Int,
    val releasedSoftware: Long?
) {
}
