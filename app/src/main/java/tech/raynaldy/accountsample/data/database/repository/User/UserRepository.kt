package tech.raynaldy.accountsample.data.database.repository.User

import io.reactivex.Observable
import javax.inject.Inject


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

class UserRepository @Inject internal constructor(private val userDao: UserDao): UserRepo {
    override fun insertUser(user: User): Observable<Boolean> =
        Observable.fromCallable {
            userDao.insertUser(user)
            return@fromCallable true
        }


    override fun loadUserFromEmail(email: String, password: String): Observable<User> {
        return Observable.fromCallable { userDao.getUserByEmail(email, password) }
    }

    override fun loadUserFromPhone(phone: String, password: String): Observable<User> {
        return Observable.fromCallable { userDao.getUserByPhone(phone, password) }
    }

    override fun loadUsers(): Observable<List<User>> {
        return Observable.fromCallable { userDao.getAllUsers() }
    }

}