package reddit.com.mdpparser.base

/**
 * Interface for MVP presenter
 */
interface MvpPresenter<in V : MvpView> {
    fun attachView(view: V)
    fun detachView()
}