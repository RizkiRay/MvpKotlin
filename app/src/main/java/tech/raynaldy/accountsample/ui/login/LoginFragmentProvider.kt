package tech.raynaldy.accountsample.ui.login

import dagger.Module
import dagger.android.ContributesAndroidInjector
import tech.raynaldy.accountsample.ui.login.view.LoginFragment


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

@Module
abstract class LoginFragmentProvider {

    @ContributesAndroidInjector(modules = [LoginFragmentModule::class])
    abstract internal fun provideLoginFragment(): LoginFragment

}