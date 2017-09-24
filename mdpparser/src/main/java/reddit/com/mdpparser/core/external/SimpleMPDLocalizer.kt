package reddit.com.mdpparser.core.external

import android.net.Uri
import reddit.com.mdpparser.core.mapper.MPDMapper
import reddit.com.mdpparser.core.parser.MPDParser
import reddit.com.mdpparser.data.model.DashManifest
import java.io.InputStream
import javax.inject.Inject


class SimpleMPDLocalizer @Inject constructor(private val parser: MPDParser,
                                                      private val mapper: MPDMapper): MPDLocalizer {

    override fun localize(uri: Uri, inputStream: InputStream) {
        val manifest : DashManifest = parser.parseManifest(uri, inputStream) as DashManifest
        val map = mapper.map(manifest)
    }

}