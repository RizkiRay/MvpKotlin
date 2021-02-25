package tech.raynaldy.accountsample.ui.base.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

abstract class BaseActivity: AppCompatActivity(), MvpView, BaseFragment.CallBack {
    override fun onCreate(savedInstanceState: Bundle?) {
        performDI()
        super.onCreate(savedInstanceState)
    }

    private fun performDI() = AndroidInjection.inject(this)
}