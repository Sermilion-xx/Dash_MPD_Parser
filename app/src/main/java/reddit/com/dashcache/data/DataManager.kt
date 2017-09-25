package reddit.com.dashcache.data

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import reddit.com.dashcache.data.remote.RetrofitService
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(private val retrofitService: RetrofitService) {

    fun getManifest(url: String): Observable<Response<ResponseBody>> {
        return retrofitService.getManifest(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}