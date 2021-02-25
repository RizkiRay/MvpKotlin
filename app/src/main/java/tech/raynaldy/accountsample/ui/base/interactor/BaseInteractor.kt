package tech.raynaldy.accountsample.ui.base.interactor

import tech.raynaldy.accountsample.data.network.ApiHelper
import tech.raynaldy.accountsample.data.preferences.PreferenceHelper


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

open class BaseInteractor() : MvpInteractor {
    protected lateinit var preferenceHelper: PreferenceHelper
    protected lateinit var apiHelper: ApiHelper

    constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : this() {
        this.preferenceHelper = preferenceHelper
        this.apiHelper = apiHelper
    }
}