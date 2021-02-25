package tech.raynaldy.accountsample.ui.login.interactor

import android.content.Context
import io.reactivex.Observable
import tech.raynaldy.accountsample.data.database.repository.User.User
import tech.raynaldy.accountsample.data.database.repository.User.UserRepo
import tech.raynaldy.accountsample.data.network.ApiHelper
import tech.raynaldy.accountsample.data.preferences.PreferenceHelper
import tech.raynaldy.accountsample.ui.base.interactor.BaseInteractor
import tech.raynaldy.accountsample.ui.main.interactor.MainMvpInteractor
import javax.inject.Inject


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

class LoginInteractor
@Inject internal constructor(
    private val mContext: Context,
    private val userRepoHelper: UserRepo,
    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper
) :
    BaseInteractor(preferenceHelper = preferenceHelper, apiHelper = apiHelper), LoginMvpInteractor {
    override fun getAllUsers(): Observable<List<User>> {
        return userRepoHelper.loadUsers()
    }

    override fun getUserByPhone(phone: String, password: String): Observable<User> {
        return userRepoHelper.loadUserFromPhone(phone, password)
    }

    override fun getUserByEmail(email: String, password: String): Observable<User> {
        return userRepoHelper.loadUserFromEmail(email, password)
    }

}