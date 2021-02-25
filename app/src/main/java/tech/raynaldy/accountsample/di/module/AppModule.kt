package tech.raynaldy.accountsample.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import tech.raynaldy.accountsample.data.database.AppDatabase
import tech.raynaldy.accountsample.data.database.repository.User.UserRepo
import tech.raynaldy.accountsample.data.database.repository.User.UserRepository
import tech.raynaldy.accountsample.data.network.ApiHelper
import tech.raynaldy.accountsample.data.network.AppApiHelper
import tech.raynaldy.accountsample.data.preferences.AppPreferenceHelper
import tech.raynaldy.accountsample.data.preferences.PreferenceHelper
import tech.raynaldy.accountsample.di.PreferenceInfo
import tech.raynaldy.accountsample.util.AppConstants
import tech.raynaldy.accountsample.util.SchedulerProvider
import javax.inject.Singleton


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

@Module
class AppModule {
    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.DB_NAME).build()


    @Provides
    @PreferenceInfo
    internal fun provideprefFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper


    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()

    @Provides
    @Singleton
    internal fun provideUserRepoHelper(appDatabase: AppDatabase): UserRepo = UserRepository(appDatabase.userDao())
}