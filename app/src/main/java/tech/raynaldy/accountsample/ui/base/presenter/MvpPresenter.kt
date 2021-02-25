package tech.raynaldy.accountsample.ui.base.presenter

import io.reactivex.disposables.CompositeDisposable
import tech.raynaldy.accountsample.ui.base.interactor.MvpInteractor
import tech.raynaldy.accountsample.ui.base.view.MvpView
import tech.raynaldy.accountsample.util.SchedulerProvider


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

interface MvpPresenter<V : MvpView, I : MvpInteractor> {
    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?
}