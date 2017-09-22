package reddit.com.mdpparser.parser

import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import reddit.com.mdpparser.data.DataManager
import reddit.com.mdpparser.data.model.MPD
import javax.inject.Inject

/**
 * Presenter for parsing MPD XML
 */
class MDPParserPresenter @Inject constructor(private val dataManager: DataManager): MDPParserContract.Presenter<MPD>() {

    private var disposables: Disposable? = null

    override fun parse(url: String) {
        dataManager.parse(url).subscribe(object : Observer<MPD> {

            override fun onComplete() {

            }

            override fun onError(e: Throwable) {
                view.onParseFail(e)
            }

            override fun onSubscribe(d: Disposable) {
                disposables = d
            }

            override fun onNext(value: MPD) {
                view.onMpdReady(value)
            }
        })
    }

    override fun detachView() {
        super.detachView()
        disposables?.dispose()
    }
}