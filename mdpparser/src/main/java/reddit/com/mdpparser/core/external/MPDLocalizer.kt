package reddit.com.mdpparser.core.external

import android.net.Uri
import java.io.InputStream

interface MPDLocalizer {

    fun localize(uri: Uri, inputStream: InputStream)

}