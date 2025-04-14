package de.roskenet.helium

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus.Series.SUCCESSFUL
import org.springframework.http.client.ClientHttpResponse
import org.springframework.stereotype.Component
import org.zalando.riptide.Bindings.on
import org.zalando.riptide.Http
import org.zalando.riptide.Navigators.series
import java.util.concurrent.CompletableFuture

data class Artist(val name: String, val birthYear: Int)

@Component
class HydrogenClient {

    @Autowired
    @Qualifier("hydrogen")
    lateinit var hydrogenClient: Http

    fun checkHydrogen(): CompletableFuture<ClientHttpResponse?>? {
        val dispatch = hydrogenClient.get("/artist?name={name}", "Elvis")
            .dispatch(
                series(),
                on(SUCCESSFUL).call<Artist>(Artist::class.java) {
                    printArtist(it)
                })

        return dispatch
    }

    fun printArtist(artist: Artist) {
       println(artist)
    }
}