package com.walter.image.controller

import com.walter.image.dto.console.ConsoleInfoResponse
import com.walter.image.dto.console.ConsoleRegisterRequest
import com.walter.image.service.ConsoleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/console")
@RestController
class ConsoleController constructor (
    private val consoleService: ConsoleService
) {
    @PostMapping("/register")
    fun register(@RequestBody request: ConsoleRegisterRequest) {
        consoleService.saveConsole(request)
    }

    @GetMapping("/{id}")
    fun findConsoleById(@PathVariable("id") id: Long) : ConsoleInfoResponse {
        return consoleService.findConsoleById(id)
    }
}