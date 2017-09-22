package reddit.com.mdpparser.parser

import reddit.com.mdpparser.base.BaseMvpPresenter
import reddit.com.mdpparser.base.MvpView

/**
 * Contract to be implemented by presenter and view that is going to be used to parse MPD MXL file
 */
object MDPParserContract {

    interface View<in T>: MvpView {
        fun onMpdReady(value: T)
        fun onParseFail(e: Throwable)
    }

    abstract class Presenter<T>: BaseMvpPresenter<View<T>>() {
        abstract fun parse(url: String)
    }
}