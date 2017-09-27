package reddit.com.mdpparser.util

/**
 * Created by sermilion on 9/27/17.
 */
object UtilString {

    fun getLast(string: String, delimiter: String) =
            string.split(Regex(delimiter)).last()
}