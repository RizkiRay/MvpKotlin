package tech.raynaldy.accountsample.ui.main.presenter

import io.reactivex.disposables.CompositeDisposable
import tech.raynaldy.accountsample.ui.base.presenter.BasePresenter
import tech.raynaldy.accountsample.ui.main.interactor.MainMvpInteractor
import tech.raynaldy.accountsample.ui.main.view.MainMvpView
import tech.raynaldy.accountsample.util.SchedulerProvider
import javax.inject.Inject


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

class MainPresenter<V: MainMvpView, I: MainMvpInteractor>
    @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) :
        BasePresenter<V,I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable),
        MainMvpPresenter<V,I> {
    override fun onAttach(view: V?) {
        super.onAttach(view)

    }
}