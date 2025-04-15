package de.roskenet.helium

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.Series.CLIENT_ERROR
import org.springframework.http.HttpStatus.Series.SUCCESSFUL
import org.springframework.stereotype.Component
import org.zalando.riptide.Bindings.on
import org.zalando.riptide.Http
import org.zalando.riptide.Navigators.series
import org.zalando.riptide.Navigators.status
import org.zalando.riptide.capture.Capture

data class Artist(val name: String, val birthYear: Int)

@Component
class HydrogenClient {

    @Autowired
    @Qualifier("hydrogen")
    lateinit var hydrogenClient: Http

    fun checkHydrogenNonBlocking(func: (Artist) -> Unit) {
        hydrogenClient.get("/artist?name={name}", "Elvis")
            .dispatch(
                series(),
                on(SUCCESSFUL).call<Artist>(Artist::class.java) {
                    func(it)
                })
    }

    fun checkHydrogenBlocking(): Artist {
        val capture = Capture.empty<Artist>()

        val artist = hydrogenClient.get("/artist?name{name}", "Elvis")
            .dispatch(series(),
                on(SUCCESSFUL)
                    .call(Artist::class.java, capture),
                on(CLIENT_ERROR)
                    .dispatch(status(),
                        on(NOT_FOUND).call { _ -> throw IllegalArgumentException("No such artist") }
                    )
                )
            .thenApply(capture).join()

        return artist
    }
}