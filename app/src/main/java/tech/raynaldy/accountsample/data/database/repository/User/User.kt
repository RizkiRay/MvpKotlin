package tech.raynaldy.accountsample.data.database.repository.User

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

@Entity(tableName = "users")
data class User (
    @Expose
    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @Expose
    @ColumnInfo(name = "email")
    var email: String,

    @Expose
    @ColumnInfo(name = "phone")
    var phone: String,

    @Expose
    @SerializedName("first_name")
    @ColumnInfo(name = "first_name")
    var firstName: String,

    @Expose
    @SerializedName("last_name")
    @ColumnInfo(name = "last_name")
    var lastName: String,

    @Expose
    @ColumnInfo(name = "password")
    var password: String,


)