package reddit.com.mdpparser.injection.component

import dagger.Component
import reddit.com.mdpparser.core.external.MPDLocalizer
import reddit.com.mdpparser.core.external.SimpleMPDLocalizer
import reddit.com.mdpparser.data.DataManager
import reddit.com.mdpparser.injection.module.ApiModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApiModule::class))
internal interface LibraryComponent {

    fun dataManager(): DataManager

    fun inject(external: MPDLocalizer)

}