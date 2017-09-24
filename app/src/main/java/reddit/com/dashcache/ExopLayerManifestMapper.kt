package reddit.com.dashcache

import android.net.Uri
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser
import reddit.com.mdpparser.core.parser.MPDParser
import reddit.com.mdpparser.data.model.DashManifest
import reddit.com.mdpparser.data.model.ExoDashManifest
import java.io.InputStream


class ExoPlayerManifestParser : DashManifestParser(), MPDParser {
    override fun parseManifest(url: Uri, inputStream: InputStream): DashManifest =
            ExoDashManifest(parse(url, inputStream))
}