package tech.raynaldy.accountsample.ui.login.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.btnRegister
import kotlinx.android.synthetic.main.fragment_login.editPassword
import tech.raynaldy.accountsample.R
import tech.raynaldy.accountsample.ui.base.view.BaseFragment
import tech.raynaldy.accountsample.ui.login.interactor.LoginMvpInteractor
import tech.raynaldy.accountsample.ui.login.presenter.LoginMvpPresenter
import tech.raynaldy.accountsample.ui.main.view.MainActivity
import javax.inject.Inject


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

class LoginFragment : BaseFragment(), LoginMvpView {
    companion object {

        internal val TAG = "LoginFragment"

        fun newInstance(): LoginFragment {
            return LoginFragment()
        }

    }

    @Inject
    lateinit var presenter: LoginMvpPresenter<LoginMvpView, LoginMvpInteractor>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttach(this)
        setUp()
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }

    override fun setUp() {

        getBaseActivity()?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        getBaseActivity()?.supportActionBar?.setHomeButtonEnabled(false)
        setHasOptionsMenu(false)

        btnLogin.setOnClickListener {
            presenter.getUserAccount(editPhone.text.toString(), editPassword.text.toString())
        }
        btnRegister.setOnClickListener {
            Log.i(TAG, "setUp: " + (getBaseActivity() is MainActivity).toString())
            if (getBaseActivity() is MainActivity){
                (getBaseActivity() as MainActivity).openRegisterFragment()
            }
        }
    }


    override fun invalidLogin() {
        Toast.makeText(getBaseActivity(), "Invalid Credential!", Toast.LENGTH_SHORT).show()
    }
    override fun successLogin() {
        Toast.makeText(getBaseActivity(), "Login Successful!", Toast.LENGTH_SHORT).show()
    }

}