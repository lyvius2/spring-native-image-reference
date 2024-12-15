package com.walter.image.service

import com.walter.image.domain.console.Console
import com.walter.image.domain.console.ConsoleJpaRepository
import com.walter.image.dto.console.ConsoleInfoResponse
import com.walter.image.dto.console.ConsoleRegisterRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ConsoleService constructor (
    private val consoleJpaRepository: ConsoleJpaRepository
) {
    @Transactional
    fun saveConsole(request: ConsoleRegisterRequest) {
        val console = Console.from(request)
        consoleJpaRepository.save(console)
    }

    @Transactional(readOnly = true)
    fun findConsoleById(id: Long): ConsoleInfoResponse {
        val console = consoleJpaRepository.findById(id)
            .orElseThrow {
                IllegalArgumentException("Not Exists Console Id : $id")
            }
        return ConsoleInfoResponse.of(console)
    }
}