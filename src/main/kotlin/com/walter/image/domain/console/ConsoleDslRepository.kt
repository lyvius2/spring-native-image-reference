package com.walter.image.domain.console

import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import com.walter.image.domain.console.QConsole.console
import com.walter.image.dto.console.ConsoleInfoResponse
import org.springframework.stereotype.Repository

@Repository
class ConsoleDslRepository constructor(
    private val queryFactory: JPAQueryFactory
) {
    fun findById(id: Long): ConsoleInfoResponse? {
        return queryFactory.select(Projections.constructor(
            ConsoleInfoResponse::class.java,
            console.id,
            console.name,
            console.manufacturer,
            console.releaseYear,
            console.softwareList.size()
        ))
            .from(console)
            .where(console.id.eq(id))
            .fetchOne()
    }
}