package de.roskenet.hydrogen

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HydrogenApplication

fun main(args: Array<String>) {
    runApplication<HydrogenApplication>(*args)
}
