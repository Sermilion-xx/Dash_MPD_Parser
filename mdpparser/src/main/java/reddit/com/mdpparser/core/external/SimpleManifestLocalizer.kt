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
        val xml = streamToString(ByteArrayInputStream(byteArray))
        println()
    }

}