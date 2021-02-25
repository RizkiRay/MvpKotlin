package tech.raynaldy.accountsample.ui.login.presenter

import tech.raynaldy.accountsample.ui.base.presenter.MvpPresenter
import tech.raynaldy.accountsample.ui.login.interactor.LoginMvpInteractor
import tech.raynaldy.accountsample.ui.login.view.LoginMvpView


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

interface LoginMvpPresenter<V: LoginMvpView, I: LoginMvpInteractor>: MvpPresenter<V,I> {
    fun loadUsers()
    fun getUserAccount(user:String, password:String)
}