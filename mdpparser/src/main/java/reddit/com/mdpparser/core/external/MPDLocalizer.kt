package reddit.com.mdpparser.core.external

import android.net.Uri
import reddit.com.mdpparser.data.model.DashManifest
import java.io.InputStream

interface MPDLocalizer {

    fun localize(uri: Uri, inputStream: InputStream): DashManifest

}