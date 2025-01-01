package com.walter.image.dto.software

import com.walter.image.domain.software.Ganre

data class SoftwareRegisterRequest(
    val name: String,
    val maker: String,
    val releaseDate: String,
    val ganre: Ganre = Ganre.ETC,
    val consoleId: Long?,
)