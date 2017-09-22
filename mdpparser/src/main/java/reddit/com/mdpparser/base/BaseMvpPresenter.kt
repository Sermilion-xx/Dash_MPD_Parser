package reddit.com.mdpparser.base

/**
 * Base class for extension by MVP presenters
 */
open class BaseMvpPresenter<T : MvpView> : MvpPresenter<T> {

    private var _view: T? = null
    val view: T
        get() = _view ?: throw MvpViewNotAttachedException()

    override fun attachView(view: T) {
        _view = view
    }

    override fun detachView() {
        _view = null
    }

    class MvpViewNotAttachedException : RuntimeException(
            "Please call MvpPresenter.attachView(MvpView) before requesting data to the MvpPresenter")
}