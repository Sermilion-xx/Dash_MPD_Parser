package reddit.com.dashcache.injection.component

import dagger.Subcomponent
import reddit.com.dashcache.injection.PerActivity
import reddit.com.dashcache.injection.module.ActivityModule
import reddit.com.dashcache.MainActivity

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(activity: MainActivity)
}
