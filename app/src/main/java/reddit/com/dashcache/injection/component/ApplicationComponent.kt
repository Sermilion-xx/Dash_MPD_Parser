package reddit.com.dashcache.injection.component

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Component
import net.oneread.oneread.injection.module.ApplicationModule
import reddit.com.dashcache.data.DataManager
import reddit.com.dashcache.data.remote.RetrofitService
import reddit.com.dashcache.injection.ApplicationContext
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

//exposing dependencies from ApplicationComponent to components that depend on it
    @ApplicationContext
    fun context(): Context
    fun application(): Application
    fun oneAccountService(): RetrofitService
    fun dataManager(): DataManager
}
