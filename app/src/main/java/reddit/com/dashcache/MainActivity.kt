package reddit.com.dashcache

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import reddit.com.mdpparser.data.model.MPD
import reddit.com.mdpparser.injection.DaggerWrapper


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerWrapper.getComponent().dataManager().parse("2lw0j1hpq8nz/DASHPlaylist").subscribe(object : Observer<MPD> {

            override fun onComplete() {

            }

            override fun onError(e: Throwable) {
                throw Exception(e)
            }

            override fun onSubscribe(d: Disposable) {
                println()
            }

            override fun onNext(value: MPD) {
                println()
            }
        })
    }
}
