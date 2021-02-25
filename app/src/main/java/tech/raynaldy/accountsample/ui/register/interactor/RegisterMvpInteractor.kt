package tech.raynaldy.accountsample.ui.register.interactor

import io.reactivex.Observable
import tech.raynaldy.accountsample.data.database.repository.User.User
import tech.raynaldy.accountsample.ui.base.interactor.MvpInteractor


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

interface RegisterMvpInteractor: MvpInteractor {
    fun insertUser(user: User): Observable<Boolean>
}