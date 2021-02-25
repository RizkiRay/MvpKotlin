package tech.raynaldy.accountsample.ui.register

import dagger.Module
import dagger.android.ContributesAndroidInjector
import tech.raynaldy.accountsample.ui.login.LoginFragmentModule
import tech.raynaldy.accountsample.ui.login.view.LoginFragment
import tech.raynaldy.accountsample.ui.register.view.RegisterFragment


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */


@Module
abstract class RegisterFragmentProvider {

    @ContributesAndroidInjector(modules = [RegisterFragmentModule::class])
    abstract internal fun provideRegisterFragment(): RegisterFragment

}