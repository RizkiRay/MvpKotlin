package tech.raynaldy.accountsample.ui.main.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import tech.raynaldy.accountsample.R
import tech.raynaldy.accountsample.ui.base.view.BaseActivity
import tech.raynaldy.accountsample.ui.login.view.LoginFragment
import tech.raynaldy.accountsample.ui.main.interactor.MainMvpInteractor
import tech.raynaldy.accountsample.ui.main.presenter.MainMvpPresenter
import tech.raynaldy.accountsample.ui.register.view.RegisterFragment
import javax.inject.Inject


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

class MainActivity : BaseActivity(), MainMvpView, HasSupportFragmentInjector {

    @Inject
    internal lateinit var presenter: MainMvpPresenter<MainMvpView, MainMvpInteractor>
    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttach(this)
        toolbar.title = "Login"
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            openLoginFragment()
        }
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector

    override fun openRegisterFragment() {
        toolbar.title = "Register"
        Log.i("TAG", "openRegisterFragment: called")
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, RegisterFragment.newInstance(), "RegisterFragment")
            .commit()
    }

    override fun openLoginFragment() {
        toolbar.title = "Login"
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, LoginFragment.newInstance(), "LoginFragment")
            .commit()
    }

}