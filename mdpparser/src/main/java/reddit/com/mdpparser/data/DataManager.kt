package reddit.com.mdpparser.data

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import reddit.com.mdpparser.data.remote.MDPParserService
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Data Manager for accessing local and remote data
 */

@Singleton
class DataManager @Inject constructor(private val mdpParserService: MDPParserService) {

    fun parse(url: String): Observable<Response<ResponseBody>> {
        return mdpParserService.getMPD(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}