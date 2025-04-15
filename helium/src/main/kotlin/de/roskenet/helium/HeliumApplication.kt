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

		// This is a non-blocking call!
//		hydrogenClient.checkHydrogenNonBlocking(::doSomething)
		val artist = hydrogenClient.checkHydrogenBlocking()
		println(artist)

		println("Erster!")
	}
}

fun main(args: Array<String>) {
	runApplication<HeliumApplication>(*args)
}

fun doSomething(a: Artist) {
	if (a.name.startsWith("Elvis", 0, false)) {
		println("Elvis is here!")
	} else {
		println("Elvis is not here!")
		println("Instead we have ${a.name} for you!")
	}

}