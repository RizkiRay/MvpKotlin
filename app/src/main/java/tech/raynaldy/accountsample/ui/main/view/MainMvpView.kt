package tech.raynaldy.accountsample.ui.main.view

import tech.raynaldy.accountsample.ui.base.view.MvpView


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

interface MainMvpView: MvpView {
    fun openRegisterFragment()
    fun openLoginFragment()
}