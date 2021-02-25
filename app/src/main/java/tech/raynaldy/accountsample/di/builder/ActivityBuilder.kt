package tech.raynaldy.accountsample.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import tech.raynaldy.accountsample.ui.login.LoginFragmentModule
import tech.raynaldy.accountsample.ui.login.LoginFragmentProvider
import tech.raynaldy.accountsample.ui.main.MainActivityModule
import tech.raynaldy.accountsample.ui.main.view.MainActivity
import tech.raynaldy.accountsample.ui.register.RegisterFragmentProvider


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [(MainActivityModule::class),(LoginFragmentProvider::class), (RegisterFragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity
}