package tech.raynaldy.accountsample.ui.login.presenter

import android.text.TextUtils
import android.util.Log
import io.reactivex.disposables.CompositeDisposable
import tech.raynaldy.accountsample.ui.base.presenter.BasePresenter
import tech.raynaldy.accountsample.ui.login.interactor.LoginMvpInteractor
import tech.raynaldy.accountsample.ui.login.view.LoginMvpView
import tech.raynaldy.accountsample.ui.main.interactor.MainMvpInteractor
import tech.raynaldy.accountsample.ui.main.presenter.MainMvpPresenter
import tech.raynaldy.accountsample.ui.main.view.MainMvpView
import tech.raynaldy.accountsample.util.SchedulerProvider
import javax.inject.Inject


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

class LoginPresenter<V: LoginMvpView, I: LoginMvpInteractor>
@Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) :
    BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable),
    LoginMvpPresenter<V, I> {
    override fun onAttach(view: V?) {
        super.onAttach(view)

    }

    override fun loadUsers() {
        Log.i("TEST", "getAllUsers: called " + (interactor == null).toString())
        getAllUsers()
    }

    private fun getAllUsers() = interactor?.let {
        Log.i("TEST", "getAllUsers: called inside")
        if (compositeDisposable.isDisposed) Log.i("TAG", "getAllUsers: disposed")
        else Log.i("TAG", "getAllUsers: !disposed")
        compositeDisposable.add(it.getAllUsers()
            .compose(schedulerProvider.ioToMainObservableScheduler())
            .subscribe { users ->
                users.forEach { user ->
                    Log.i("TAG", "getAllUsers: ${user.email}")
                }
            })
    }

    override fun getUserAccount(user: String, password: String) {
        if (user.isEmailValid()) {
            getUserByEmail(user, password)
        } else if (user.isPhoneValid()) {
            getUserByPhone(user, password)
        }
        Log.i("TAG", "getUserAccount: " + user.isEmailValid())
        Log.i("TAG", "getUserAccount: phone " + user.isPhoneValid())
    }

    private fun getUserByPhone(phone: String, password: String) = interactor?.let {
        compositeDisposable.addAll(
            it.getUserByPhone(phone, password)
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe({ user ->
                    Log.i("TAG", "getUserByPhone: " + user.phone + " " + user.firstName)
                    getView()?.successLogin()
                }, { err ->
                    Log.i("TAG", "getUserByPhone: $err")
                    getView()?.invalidLogin()
                })
        )
    }

    private fun getUserByEmail(email: String, password: String) = interactor?.let {
        compositeDisposable.addAll(it.getUserByEmail(email, password)
            .compose(schedulerProvider.ioToMainObservableScheduler())
            .subscribe ({user ->
                getView()?.successLogin()
                Log.i("TAG", "getUserByEmail: " + user.phone + " " + user.firstName)
            },{ err ->
                Log.i("TAG", "getUserByEmail: $err")
                getView()?.invalidLogin()
        })
        )
    }

    private fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    private fun String.isPhoneValid(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.PHONE.matcher(this).matches();
    }

}