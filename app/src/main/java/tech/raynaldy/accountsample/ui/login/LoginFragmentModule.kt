package tech.raynaldy.accountsample.ui.login

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import tech.raynaldy.accountsample.ui.login.interactor.LoginInteractor
import tech.raynaldy.accountsample.ui.login.interactor.LoginMvpInteractor
import tech.raynaldy.accountsample.ui.login.presenter.LoginMvpPresenter
import tech.raynaldy.accountsample.ui.login.presenter.LoginPresenter
import tech.raynaldy.accountsample.ui.login.view.LoginFragment
import tech.raynaldy.accountsample.ui.login.view.LoginMvpView


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

@Module
class LoginFragmentModule {

    @Provides
    internal fun provideLoginInteractor(interactor: LoginInteractor): LoginMvpInteractor = interactor

    @Provides
    internal fun provideLoginPresenter(presenter: LoginPresenter<LoginMvpView, LoginMvpInteractor>)
            : LoginMvpPresenter<LoginMvpView, LoginMvpInteractor> = presenter
}