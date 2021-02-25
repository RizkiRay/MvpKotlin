package tech.raynaldy.accountsample.ui.login.view

import tech.raynaldy.accountsample.ui.base.view.MvpView


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

interface LoginMvpView: MvpView {
    fun invalidLogin()
    fun successLogin()
}