package tech.raynaldy.accountsample.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import tech.raynaldy.accountsample.data.database.repository.User.User
import tech.raynaldy.accountsample.data.database.repository.User.UserDao


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

@Database(entities = [(User::class)], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}