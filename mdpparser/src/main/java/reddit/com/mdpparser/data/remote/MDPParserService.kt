package reddit.com.mdpparser.data.remote

import io.reactivex.Observable
import reddit.com.mdpparser.data.model.MPD
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Collection of requests for Retrofit
 */
interface MDPParserService {

    @GET("{param}.mpd")
    fun getMPD(@Path("param")url: String): Observable<MPD>

}