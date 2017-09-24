package reddit.com.mdpparser.injection

import reddit.com.mdpparser.injection.component.DaggerLibraryComponent
import reddit.com.mdpparser.injection.component.LibraryComponent

/**
 * Class for creating instance of dependency injection component
 */
internal class DaggerWrapper private constructor(){

    companion object {
        fun getComponent(): LibraryComponent = SingletonHelper.INSTANCE

        class SingletonHelper {
            companion object {
                 var INSTANCE: LibraryComponent = DaggerLibraryComponent
                .builder()
                .build()
            }
        }
    }

}