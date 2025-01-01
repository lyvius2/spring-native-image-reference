package com.walter.image.service

import com.walter.image.domain.console.ConsoleJpaRepository
import com.walter.image.domain.software.Software
import com.walter.image.domain.software.SoftwareJpaRepository
import com.walter.image.dto.software.SoftwareRegisterRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SoftwareService constructor(
    private val softwareJpaRepository: SoftwareJpaRepository,
    private val consoleJpaRepository: ConsoleJpaRepository,
) {
    @Transactional
    fun saveSoftware(request: SoftwareRegisterRequest) {
        val console = request.consoleId?.let { consoleJpaRepository.findById(it) }
        val software = Software.from(request, console?.orElse(null))
        softwareJpaRepository.save(software)
    }
}