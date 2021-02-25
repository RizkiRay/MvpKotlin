package tech.raynaldy.accountsample.ui.register.presenter

import tech.raynaldy.accountsample.data.database.repository.User.User
import tech.raynaldy.accountsample.ui.base.presenter.BasePresenter
import tech.raynaldy.accountsample.ui.base.presenter.MvpPresenter
import tech.raynaldy.accountsample.ui.register.interactor.RegisterMvpInteractor
import tech.raynaldy.accountsample.ui.register.view.RegisterMvpView


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

interface RegisterMvpPresenter<V: RegisterMvpView, I: RegisterMvpInteractor>: MvpPresenter<V,I>{
    fun registerUser(user: User)

    fun isEmailValid(email: String): Boolean

    fun isPhoneValid(phone: String): Boolean

    fun isPasswordValid(pass: String?): Boolean
}