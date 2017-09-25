package reddit.com.mdpparser.core.external

import android.net.Uri
import reddit.com.mdpparser.core.mapper.LocalUrlMPDMapper
import reddit.com.mdpparser.core.parser.ExoPlayerManifestParser
import reddit.com.mdpparser.data.model.DashManifest
import reddit.com.mdpparser.injection.DaggerWrapper
import java.io.InputStream
import javax.inject.Inject


class SimpleMPDLocalizer
@Inject constructor(private val parser: ExoPlayerManifestParser,
                        private val mapper: LocalUrlMPDMapper
): MPDLocalizer {

    init {
        DaggerWrapper.getComponent().inject(this)
    }

    override fun localize(uri: Uri, inputStream: InputStream) {
        val manifest : DashManifest = parser.parseManifest(uri, inputStream)
        val map = mapper.map(manifest)
    }

}