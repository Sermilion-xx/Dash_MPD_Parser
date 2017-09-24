package reddit.com.mdpparser.core.parser

import android.net.Uri
import reddit.com.mdpparser.data.model.DashManifest
import java.io.InputStream

interface MPDParser {

    fun parseManifest(url: Uri, inputStream: InputStream): DashManifest

}