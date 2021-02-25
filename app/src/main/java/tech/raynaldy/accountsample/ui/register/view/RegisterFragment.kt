package tech.raynaldy.accountsample.ui.register.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.fragment_login.btnRegister
import kotlinx.android.synthetic.main.fragment_register.*
import tech.raynaldy.accountsample.R
import tech.raynaldy.accountsample.data.database.repository.User.User
import tech.raynaldy.accountsample.ui.base.view.BaseFragment
import tech.raynaldy.accountsample.ui.main.view.MainActivity
import tech.raynaldy.accountsample.ui.register.interactor.RegisterMvpInteractor
import tech.raynaldy.accountsample.ui.register.presenter.RegisterMvpPresenter
import javax.inject.Inject


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

class RegisterFragment : BaseFragment(), RegisterMvpView {
    companion object {

        internal val TAG = "RegisterFragment"

        fun newInstance(): RegisterFragment {
            return RegisterFragment()
        }

    }

    @Inject
    lateinit var presenter: RegisterMvpPresenter<RegisterMvpView, RegisterMvpInteractor>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_register, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttach(this)
        setUp()
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
        {
            if (getBaseActivity() is MainActivity) {
                (getBaseActivity() as MainActivity).openLoginFragment()
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun setUp() {

        getBaseActivity()?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        getBaseActivity()?.supportActionBar?.setHomeButtonEnabled(true)
        setHasOptionsMenu(true)

        editEmail.doAfterTextChanged {
            if (!presenter.isEmailValid(it.toString())) editEmail.error = "Invalid Email"
        }

        editPhone.doAfterTextChanged {
            if (!presenter.isPhoneValid(it.toString())) editPhone.error = "Invalid Phone"
        }

        editPassword.doAfterTextChanged {
            if (!presenter.isPasswordValid(it.toString())) editPassword.error = "Password weak"
        }

        btnRegister.setOnClickListener {
            val user = User(
                0,
                editEmail.text.toString(),
                editPhone.text.toString(),
                editFirstName.text.toString(),
                editLastName.text.toString(),
                editPassword.text.toString()
            )
            presenter.registerUser(user)
        }

    }

    override fun onRegisterFinished() {
        Toast.makeText(getBaseActivity(), "Register successful!", Toast.LENGTH_SHORT).show()
        editEmail.text.clear()
        editFirstName.text.clear()
        editLastName.text.clear()
        editPhone.text.clear()
        editPassword.text.clear()
    }

}