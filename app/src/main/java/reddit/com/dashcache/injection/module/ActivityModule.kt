package reddit.com.dashcache.injection.module

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import reddit.com.dashcache.injection.ActivityContext
import reddit.com.dashcache.injection.PerActivity

@Module
open class ActivityModule(protected val activity: Activity) {

    @Provides
    @PerActivity
    internal fun provideScreen(): Activity = activity

    @Provides
    @PerActivity
    @ActivityContext
    internal fun providesContext(): Context = activity

}
