package tech.raynaldy.accountsample.ui.register

import dagger.Module
import dagger.Provides
import tech.raynaldy.accountsample.ui.login.interactor.LoginInteractor
import tech.raynaldy.accountsample.ui.login.interactor.LoginMvpInteractor
import tech.raynaldy.accountsample.ui.login.presenter.LoginMvpPresenter
import tech.raynaldy.accountsample.ui.login.presenter.LoginPresenter
import tech.raynaldy.accountsample.ui.login.view.LoginMvpView
import tech.raynaldy.accountsample.ui.register.interactor.RegisterInteractor
import tech.raynaldy.accountsample.ui.register.interactor.RegisterMvpInteractor
import tech.raynaldy.accountsample.ui.register.presenter.RegisterMvpPresenter
import tech.raynaldy.accountsample.ui.register.presenter.RegisterPresenter
import tech.raynaldy.accountsample.ui.register.view.RegisterMvpView


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

@Module
class RegisterFragmentModule {

    @Provides
    internal fun provideRegisterInteractor(interactor: RegisterInteractor): RegisterMvpInteractor = interactor

    @Provides
    internal fun provideRegisterPresenter(presenter: RegisterPresenter<RegisterMvpView, RegisterMvpInteractor>)
            : RegisterMvpPresenter<RegisterMvpView, RegisterMvpInteractor> = presenter
}