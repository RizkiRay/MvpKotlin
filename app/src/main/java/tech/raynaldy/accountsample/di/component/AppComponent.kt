package tech.raynaldy.accountsample.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import tech.raynaldy.accountsample.MyApp
import tech.raynaldy.accountsample.di.builder.ActivityBuilder
import tech.raynaldy.accountsample.di.module.AppModule
import javax.inject.Singleton


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (AppModule::class), (ActivityBuilder::class)])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
    fun inject(app: MyApp)
}