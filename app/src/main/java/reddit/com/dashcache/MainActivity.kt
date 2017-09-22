package reddit.com.dashcache

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.exoplayer2.source.dash.manifest.DashManifest
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import okhttp3.ResponseBody
import reddit.com.mdpparser.core.mapper.LocalUrlMapper
import reddit.com.mdpparser.injection.DaggerWrapper
import reddit.com.mdpparser.injection.module.ApiModule
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    companion object {
        val address = "cdl33f9jwbkz/DASHPlaylist"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a = DashManifestParser()
        DaggerWrapper.getComponent().dataManager().parse(address).subscribe(object : Observer<Response<ResponseBody>> {

            override fun onComplete() {

            }

            override fun onError(e: Throwable) {
                throw Exception(e)
            }

            override fun onSubscribe(d: Disposable) {
                println()
            }

            override fun onNext(value: Response<ResponseBody>) {
                value.body().use({ responseBody ->
                    val inputStream = responseBody.byteStream()
                    val manifest :DashManifest = a.parse(Uri.parse(ApiModule.BASE_URL + address+".mpd"), inputStream)
                    val map = LocalUrlMapper.getInstance().map(manifest)
                    println()
                })
            }
        })
    }
}
