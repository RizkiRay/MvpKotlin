package tech.raynaldy.accountsample.ui.main.presenter

import tech.raynaldy.accountsample.ui.base.presenter.MvpPresenter
import tech.raynaldy.accountsample.ui.main.interactor.MainMvpInteractor
import tech.raynaldy.accountsample.ui.main.view.MainMvpView


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

interface MainMvpPresenter<V: MainMvpView, I: MainMvpInteractor>: MvpPresenter<V,I> {

}