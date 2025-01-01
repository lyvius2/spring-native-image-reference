package com.walter.image.domain.software

import com.walter.image.domain.console.Console
import com.walter.image.dto.software.SoftwareRegisterRequest
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.LocalDate
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE

@Entity
class Software constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val maker: String,
    val ganre: String,
    val releaseDate: LocalDate? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "console_id", nullable = true)
    val console: Console?
) {
    companion object {
        fun from(request: SoftwareRegisterRequest, console: Console?): Software {
            try {
                val releaseDate: LocalDate = LocalDate.parse(request.releaseDate, ISO_LOCAL_DATE)
                return Software(
                    name = request.name,
                    maker = request.maker,
                    ganre = request.ganre.name,
                    releaseDate = releaseDate,
                    console = console
                )
            } catch (e: IllegalArgumentException) {
                throw IllegalArgumentException("발매일 입력 값 에러 : ${request.releaseDate}")
            }
        }
    }
}