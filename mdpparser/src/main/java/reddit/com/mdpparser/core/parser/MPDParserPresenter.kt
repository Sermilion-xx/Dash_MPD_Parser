package reddit.com.mdpparser.core.parser

import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import okhttp3.ResponseBody
import reddit.com.mdpparser.data.DataManager
import retrofit2.Response
import javax.inject.Inject

/**
 * Presenter for parsing MPD XML
 */
class MPDParserPresenter @Inject constructor(private val dataManager: DataManager): MPDParserContract.Presenter<Response<ResponseBody>>() {

    private var disposables: Disposable? = null

    override fun parse(url: String) {
        dataManager.parse(url).subscribe(object : Observer<Response<ResponseBody>> {

            override fun onComplete() {

            }

            override fun onError(e: Throwable) {
                view.onParseFail(e)
            }

            override fun onSubscribe(d: Disposable) {
                disposables = d
            }

            override fun onNext(value: Response<ResponseBody>) {

            }
        })
    }

    override fun detachView() {
        super.detachView()
        disposables?.dispose()
    }
}