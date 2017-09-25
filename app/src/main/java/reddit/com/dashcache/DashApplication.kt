package reddit.com.dashcache

import android.app.Application
import android.support.annotation.VisibleForTesting
import net.oneread.oneread.injection.module.ApplicationModule
import reddit.com.dashcache.injection.component.ApplicationComponent
import reddit.com.dashcache.injection.component.DaggerApplicationComponent

/**
 * Created by sermilion on 9/23/17.
 */
open class DashApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent
    private set

            override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        initDaggerComponent()
    }

    @VisibleForTesting
    fun initDaggerComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    fun setComponent(component: ApplicationComponent) {
        this.applicationComponent = component
    }

    companion object {
        lateinit var INSTANCE: DashApplication
            private set
    }
}