package com.walter.image.domain.software

import org.springframework.data.jpa.repository.JpaRepository

interface SoftwareJpaRepository : JpaRepository<Software, Long> {
}