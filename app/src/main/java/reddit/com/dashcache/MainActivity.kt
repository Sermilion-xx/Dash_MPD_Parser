package reddit.com.dashcache

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import reddit.com.dashcache.injection.component.ActivityComponent
import reddit.com.dashcache.injection.component.ConfigPersistentComponent
import reddit.com.dashcache.injection.component.DaggerConfigPersistentComponent
import reddit.com.dashcache.injection.module.ActivityModule
import reddit.com.mdpparser.core.external.SimpleMPDLocalizer
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
    lateinit var activityComponent: ActivityComponent
        get

//    @Inject lateinit var simpleMPDLocalizer: SimpleMPDLocalizer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDI(savedInstanceState)
        activityComponent.inject(this)

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
