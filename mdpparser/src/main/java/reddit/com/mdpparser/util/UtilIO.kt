package reddit.com.mdpparser.util

import org.apache.commons.io.IOUtils
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.util.*

object UtilIO {

    @JvmStatic
    fun streamToString(stream: InputStream): String {
        val s = Scanner(stream).useDelimiter("\\A")
        return if (s.hasNext()) s.next() else ""
    }

    @JvmStatic
    fun createByteArray(inputStream: InputStream): ByteArray {
        val bytesStream = ByteArrayOutputStream()
        IOUtils.copy(inputStream, bytesStream)
        return bytesStream.toByteArray()
    }
}