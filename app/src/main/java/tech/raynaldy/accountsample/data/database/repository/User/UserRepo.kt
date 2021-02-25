package tech.raynaldy.accountsample.data.database.repository.User

import java.util.*
import io.reactivex.Observable

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

interface UserRepo {
    fun insertUser(user: User): Observable<Boolean>
    fun loadUserFromEmail(email:String, password: String): Observable<User>
    fun loadUserFromPhone(phone:String, password: String): Observable<User>
    fun loadUsers(): Observable<List<User>>
}