package tech.raynaldy.accountsample.ui.main

import dagger.Module
import dagger.Provides
import tech.raynaldy.accountsample.ui.base.interactor.MvpInteractor
import tech.raynaldy.accountsample.ui.main.interactor.MainInteractor
import tech.raynaldy.accountsample.ui.main.interactor.MainMvpInteractor
import tech.raynaldy.accountsample.ui.main.presenter.MainMvpPresenter
import tech.raynaldy.accountsample.ui.main.presenter.MainPresenter
import tech.raynaldy.accountsample.ui.main.view.MainMvpView


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

@Module
class MainActivityModule {
    @Provides
    internal fun provideMainInteractor(mainInteractor: MainInteractor): MainMvpInteractor = mainInteractor

    @Provides
    internal fun provideMainPresenter(mainPresenter: MainPresenter<MainMvpView, MainMvpInteractor>): MainMvpPresenter<MainMvpView, MainMvpInteractor> = mainPresenter
}