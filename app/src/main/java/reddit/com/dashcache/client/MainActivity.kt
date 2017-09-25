package reddit.com.dashcache.client

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import okhttp3.ResponseBody
import reddit.com.dashcache.DashApplication
import reddit.com.dashcache.R
import reddit.com.dashcache.data.DataManager
import reddit.com.dashcache.data.remote.RetrofitService
import reddit.com.dashcache.injection.component.ActivityComponent
import reddit.com.dashcache.injection.component.ConfigPersistentComponent
import reddit.com.dashcache.injection.component.DaggerConfigPersistentComponent
import reddit.com.dashcache.injection.module.ActivityModule
import reddit.com.dashcache.injection.module.ApiModule
import reddit.com.mdpparser.core.external.SimpleMPDLocalizer
import reddit.com.mdpparser.core.mapper.LocalUrlMPDMapper
import reddit.com.mdpparser.core.parser.ExoPlayerManifestParser
import retrofit2.Response
import java.util.concurrent.atomic.AtomicLong
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    companion object {
        val address = "cdl33f9jwbkz/DASHPlaylist"
        @JvmStatic private val KEY_ACTIVITY_ID = "KEY_ACTIVITY_ID"
        @JvmStatic private val NEXT_ID = AtomicLong(0)
        @JvmStatic private val componentsMap = HashMap<Long, ConfigPersistentComponent>()
    }

    private var activityId: Long = 0
    private lateinit var activityComponent: ActivityComponent

    private lateinit var simpleMPDLocalizer: SimpleMPDLocalizer

    @Inject lateinit var dataManager: DataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDI(savedInstanceState)
        activityComponent.inject(this)
        simpleMPDLocalizer = SimpleMPDLocalizer(ExoPlayerManifestParser(), LocalUrlMPDMapper())
        dataManager.getManifest(address).subscribe(object : Observer<Response<ResponseBody>> {

            override fun onComplete() {

            }

            override fun onError(e: Throwable) {
                throw Exception(e)
            }

            override fun onSubscribe(d: Disposable) {
                println()
            }

            override fun onNext(value: Response<ResponseBody>) {
                simpleMPDLocalizer.localize(Uri.parse(ApiModule.BASE_URL + address + ".mdp"), value.body().byteStream())
            }
        })

    }

    private fun initDI(savedInstanceState: Bundle?) {
        activityId = savedInstanceState?.getLong(KEY_ACTIVITY_ID) ?: NEXT_ID.getAndIncrement()
        val configPersistentComponent = componentsMap.getOrPut(activityId, {
            val component = (applicationContext as DashApplication).applicationComponent

            DaggerConfigPersistentComponent.builder()
                    .applicationComponent(component)
                    .build()
        })

        activityComponent = configPersistentComponent.activityComponent(ActivityModule(this))
    }
}
