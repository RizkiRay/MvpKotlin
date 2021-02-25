package tech.raynaldy.accountsample.ui.base.presenter

import io.reactivex.disposables.CompositeDisposable
import tech.raynaldy.accountsample.ui.base.interactor.MvpInteractor
import tech.raynaldy.accountsample.ui.base.view.MvpView
import tech.raynaldy.accountsample.util.SchedulerProvider


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

abstract class BasePresenter<V : MvpView, I : MvpInteractor>
    internal constructor(
         protected var interactor: I?,
         protected val schedulerProvider: SchedulerProvider,
         protected val compositeDisposable: CompositeDisposable) : MvpPresenter<V,I> {
    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }

}