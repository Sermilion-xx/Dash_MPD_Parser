package reddit.com.dashcache.data.remote

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface RetrofitService {

    @GET("{param}.mpd")
    fun getManifest(@Path("param")url: String): Observable<Response<ResponseBody>>
}