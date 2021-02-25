package tech.raynaldy.accountsample.ui.register.interactor

import android.content.Context
import io.reactivex.Observable
import tech.raynaldy.accountsample.data.database.repository.User.User
import tech.raynaldy.accountsample.data.database.repository.User.UserRepo
import tech.raynaldy.accountsample.data.network.ApiHelper
import tech.raynaldy.accountsample.data.preferences.PreferenceHelper
import tech.raynaldy.accountsample.ui.base.interactor.BaseInteractor
import tech.raynaldy.accountsample.ui.login.interactor.LoginMvpInteractor
import javax.inject.Inject


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */


class RegisterInteractor
@Inject internal constructor(
    private val mContext: Context,
    private val userRepoHelper: UserRepo,
    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper
) :
    BaseInteractor(preferenceHelper = preferenceHelper, apiHelper = apiHelper), RegisterMvpInteractor {

    override fun insertUser(user: User): Observable<Boolean> {
        return userRepoHelper.insertUser(user)
    }

}