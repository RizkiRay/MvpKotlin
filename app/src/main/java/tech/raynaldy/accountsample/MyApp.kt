package tech.raynaldy.accountsample

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import tech.raynaldy.accountsample.di.component.DaggerAppComponent
import javax.inject.Inject


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

class MyApp: Application(), HasActivityInjector{

    @Inject
    lateinit internal var activityDispatchAndroidInject: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = activityDispatchAndroidInject

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

}