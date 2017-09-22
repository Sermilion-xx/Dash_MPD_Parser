package reddit.com

import org.junit.Before
import org.junit.Test
import reddit.com.mdpparser.core.mapper.LocalUrlMapper

class LocalUrlMapperTest {

    private val remoteUrls = mutableListOf<String>()

    @Before
    fun before() {
        localUrlMapper = LocalUrlMapper.getInstance()
        remoteUrls.add("https://v.redd.it/cdl33f9jwbkz/DASH_2_4_M")
        remoteUrls.add("https://v.redd.it/cdl33f9jwbkz/DASH_1_4_M=\$param1\$-\$param2\$")
    }

    private lateinit var localUrlMapper: LocalUrlMapper

    @Test
    fun mappedLocalUrlsCorrect() {
        assert(localUrlMapper.createLocalUrl(remoteUrls[0], "mp4", "1") == "http://localhost:9999/video1.mp4")
    }

    @Test
    fun mappedLocalUrlsWithParamsCorrect() {
        assert(localUrlMapper.createLocalUrl(remoteUrls[2], "mp4", "1") == "http://localhost:9999/video1=-\$param1\$-\$param2\$.mp4")
    }
}