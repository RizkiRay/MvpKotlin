package tech.raynaldy.accountsample.data.database.repository.User

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    fun getUserByEmail(email: String, password: String): User

    @Query("SELECT * FROM users WHERE phone = :phone AND password = :password")
    fun getUserByPhone(phone: String, password: String): User

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>
}