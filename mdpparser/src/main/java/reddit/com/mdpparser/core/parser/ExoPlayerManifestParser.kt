package reddit.com.mdpparser.core.parser

import android.net.Uri
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser
import reddit.com.mdpparser.data.model.DashManifest
import reddit.com.mdpparser.data.model.ExoDashManifest
import java.io.InputStream


class ExoPlayerManifestParser : DashManifestParser(), MPDParser {
    override fun parseManifest(url: Uri, inputStream: InputStream): ExoDashManifest =
            ExoDashManifest(parse(url, inputStream))
}