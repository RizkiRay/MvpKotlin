package tech.raynaldy.accountsample.ui.main.interactor

import tech.raynaldy.accountsample.data.network.ApiHelper
import tech.raynaldy.accountsample.data.preferences.PreferenceHelper
import tech.raynaldy.accountsample.ui.base.interactor.BaseInteractor
import javax.inject.Inject


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

class MainInteractor
    @Inject internal constructor(
        preferenceHelper: PreferenceHelper,
        apiHelper: ApiHelper) :
    BaseInteractor(preferenceHelper = preferenceHelper, apiHelper = apiHelper), MainMvpInteractor {

}