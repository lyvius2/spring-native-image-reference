package com.walter.image.service

import com.walter.image.domain.console.Console
import com.walter.image.domain.console.ConsoleDslRepository
import com.walter.image.domain.console.ConsoleJpaRepository
import com.walter.image.dto.console.ConsoleInfoResponse
import com.walter.image.dto.console.ConsoleRegisterRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ConsoleService constructor (
    private val consoleJpaRepository: ConsoleJpaRepository,
    private val consoleDslRepository: ConsoleDslRepository,
) {
    @Transactional
    fun saveConsole(request: ConsoleRegisterRequest) {
        val console = Console.from(request)
        consoleJpaRepository.save(console)
    }

    @Transactional(readOnly = true)
    fun findConsoleById(id: Long): ConsoleInfoResponse {
        return consoleDslRepository.findById(id) ?: throw IllegalArgumentException("Not Exists Console Id : $id")
    }
}