package tech.raynaldy.accountsample.ui.login.interactor

import io.reactivex.Observable
import tech.raynaldy.accountsample.data.database.repository.User.User
import tech.raynaldy.accountsample.ui.base.interactor.MvpInteractor


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

interface LoginMvpInteractor: MvpInteractor {
    fun getAllUsers(): Observable<List<User>>
    fun getUserByPhone(phone: String, password: String): Observable<User>
    fun getUserByEmail(email: String, password: String): Observable<User>
}