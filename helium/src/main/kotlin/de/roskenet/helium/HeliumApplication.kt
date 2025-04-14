package de.roskenet.helium

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HeliumApplication : CommandLineRunner {

	@Autowired
	lateinit var hydrogenClient: HydrogenClient

	override fun run(vararg args: String?) {
		println("Hello World!")

		hydrogenClient.checkHydrogen()

		println("Erster!")
	}
}

fun main(args: Array<String>) {
	runApplication<HeliumApplication>(*args)
}
