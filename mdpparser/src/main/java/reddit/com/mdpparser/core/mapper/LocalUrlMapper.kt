package reddit.com.mdpparser.core.mapper

import android.support.annotation.NonNull
import com.google.android.exoplayer2.source.dash.manifest.DashManifest

/**
 * Mapper class to map {@code ExoPlayer DashManifest}'s urls into a map of local urls
 */
class LocalUrlMapper private constructor() : Mapper {

    companion object {

        val localhost = "http://localhost:9999/"
        val placeholder = "video"

        fun getInstance() = SingletonHelper.INSTANCE

        class SingletonHelper {
            companion object {
                var INSTANCE = LocalUrlMapper()
            }
        }
    }

    override fun map(dashManifest: DashManifest): MutableMap<String, String> {
        var localInc = 0
        val localToRemoteMap = mutableMapOf<String, String>()

        (0 until dashManifest.periodCount)
                .map { dashManifest.getPeriod(it).adaptationSets }
                .forEach {
                    it.forEach { set ->
                        set.representations.forEach { rep ->
                            run {
                                val formatArray = rep.format.containerMimeType.split(Regex("/"))
                                val format = if (formatArray.size == 2) formatArray[1] else ""
                                localToRemoteMap[createLocalUrl(rep.baseUrl, format, localInc++.toString())] = rep.baseUrl
                            }
                        }
                    }
                }
        return localToRemoteMap
    }

    fun createLocalUrl(url: String, format: String, increment: String): String =
            localhost + placeholder + increment + extractParams(url) +"." + format

    @NonNull
    private fun extractParams(url: String): String {
        val paramList = url.split(Regex("="))
        if (paramList.size == 2) {
            return "-"+paramList[1]
        }
        return ""
    }
}