package reddit.com.dashcache

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import reddit.com.mdpparser.core.external.SimpleMPDLocalizer
import reddit.com.mdpparser.core.mapper.LocalUrlMPDMapper


class MainActivity : AppCompatActivity() {

    companion object {
        val address = "cdl33f9jwbkz/DASHPlaylist"
    }

    val simpleMPDLocalizer = SimpleMPDLocalizer(ExoPlayerManifestParser(), LocalUrlMPDMapper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
