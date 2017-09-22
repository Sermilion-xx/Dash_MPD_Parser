package reddit.com.mdpparser.injection.component

import dagger.Component
import reddit.com.mdpparser.data.DataManager
import reddit.com.mdpparser.injection.module.ApiModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApiModule::class))
interface LibraryComponent {

    fun dataManager(): DataManager

}