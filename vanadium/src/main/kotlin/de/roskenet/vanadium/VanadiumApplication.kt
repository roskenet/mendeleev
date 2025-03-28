package de.roskenet.vanadium

import jakarta.servlet.http.HttpSession
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class VanadiumApplication

fun main(args: Array<String>) {
    runApplication<VanadiumApplication>(*args)
}

@RestController
class HelloController {
    @GetMapping("/hello")
    fun hello(): String {

        return "Hello World!"
    }
}