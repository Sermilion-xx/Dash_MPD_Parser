package reddit.com.mdpparser.core.mapper

/**
 * Created by Sermilion on 9/22/17.
 */
class LocalUrlMapper: Mapper {

    companion object {

        fun getInstance() = SingletonHelper.INSTANCE

        class SingletonHelper {
            companion object {
                var INSTANCE = LocalUrlMapper()
            }
        }
    }

    override fun map(urls: List<String>) {

    }

}