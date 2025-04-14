package de.roskenet.hydrogen

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

data class Artist(val name: String, val birthYear: Int)

@RestController
class ArtistCotroller {

    @GetMapping("/artist")
    fun getArtist(@RequestParam name: String): Artist {
        when (name) {
            "Elvis" -> {
                return Artist("Elvis A. Presley", 1935)
            }

            "Michael" -> {
                return Artist("Michael Jackson", 1978)
            }

            else -> {
                throw IllegalArgumentException("Unknown Artist")
            }
        }
    }

}