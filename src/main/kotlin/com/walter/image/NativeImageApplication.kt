package com.walter.image

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NativeImageApplication

fun main(args: Array<String>) {
    runApplication<NativeImageApplication>(*args)
}
