package reddit.com.mdpparser.core.external

import android.net.Uri
import reddit.com.mdpparser.core.mapper.LocalUrlMPDMapper
import reddit.com.mdpparser.core.parser.ExoPlayerManifestParser
import reddit.com.mdpparser.data.model.DashManifest
import reddit.com.mdpparser.data.model.ExoDashManifest
import reddit.com.mdpparser.injection.DaggerWrapper
import reddit.com.mdpparser.util.UtilIO.createByteArray
import reddit.com.mdpparser.util.UtilIO.streamToString
import reddit.com.mdpparser.util.UtilString.getLast
import java.io.ByteArrayInputStream
import java.io.InputStream
import javax.inject.Inject


class SimpleManifestLocalizer
@Inject constructor(private val parser: ExoPlayerManifestParser,
                        private val mapper: LocalUrlMPDMapper
): MPDLocalizer {

    companion object {
        val BASE_URL_OPEN = "<BaseURL>"
        val BASE_URL_CLOSE = "</BaseURL>"
        fun getSimpleExoManifestLocalizer(): SimpleManifestLocalizer =
                SimpleManifestLocalizer(ExoPlayerManifestParser(), LocalUrlMPDMapper())
    }

    init {
        DaggerWrapper.getComponent().inject(this)
    }

    override fun localize(uri: Uri, inputStream: InputStream) {
        val byteArray = createByteArray(inputStream)
        val manifest : DashManifest = parser.parseManifest(uri, ByteArrayInputStream(byteArray))
        val map: Map<String, String> = mapper.map(manifest)
        var xml = streamToString(ByteArrayInputStream(byteArray))
        for (url in map) {
            xml = xml.replaceFirst("$BASE_URL_OPEN${getLast(url.key, "/")}$BASE_URL_CLOSE", "$BASE_URL_OPEN${getLast(url.value, "/")}$BASE_URL_CLOSE")
        }

        println()
    }

}