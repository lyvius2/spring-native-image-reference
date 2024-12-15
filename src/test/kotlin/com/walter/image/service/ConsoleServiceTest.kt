package com.walter.image.service

import com.walter.image.domain.console.Console
import com.walter.image.domain.console.ConsoleJpaRepository
import com.walter.image.dto.console.ConsoleRegisterRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
class ConsoleServiceTest constructor (
    @Autowired val consoleService: ConsoleService,
    @Autowired val consoleJpaRepository: ConsoleJpaRepository,
){
    @Test
    @DisplayName("Console 정보의 저장이 정상적으로 완료된다.")
    fun saveConsole() {
        // given
        val consoleRegister = ConsoleRegisterRequest(
            name = "PlayStation 5",
            manufacturer = "Sony",
            releaseYear = 2020
        )

        // when & then
        assertDoesNotThrow {
            consoleService.saveConsole(consoleRegister)
        }
    }

    @Test
    @DisplayName("Console 정보의 조회 결과가 정상적으로 리턴된다.")
    fun findConsoleById() {
        // given
        val console = Console(
            name = "PlayStation 4",
            manufacturer = "Sony",
            releaseYear = 2013
        )
        val savedConsole = consoleJpaRepository.save(console)

        // when
        val consoleInfo = consoleService.findConsoleById(savedConsole.id!!)

        // when
        assertThat(consoleInfo).isNotNull
        assertEquals(consoleInfo.id, console.id)
    }
}