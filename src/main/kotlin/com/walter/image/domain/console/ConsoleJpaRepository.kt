package com.walter.image.domain.console

import org.springframework.data.jpa.repository.JpaRepository

interface ConsoleJpaRepository : JpaRepository<Console, Long> {
    fun findByName(name: String): Console?
}