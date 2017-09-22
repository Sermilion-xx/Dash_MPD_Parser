package reddit.com.mdpparser.data.remote

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Collection of requests for Retrofit
 */
interface MDPParserService {

    @GET("{param}.mpd")
    fun getMPD(@Path("param")url: String): Observable<Response<ResponseBody>>

}