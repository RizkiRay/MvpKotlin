package tech.raynaldy.accountsample.data.preferences

import android.content.Context
import tech.raynaldy.accountsample.di.PreferenceInfo
import javax.inject.Inject


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

class AppPreferenceHelper @Inject constructor(context: Context,
                                              @PreferenceInfo private val prefFileName: String) : PreferenceHelper {

}