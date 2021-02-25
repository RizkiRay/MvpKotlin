package tech.raynaldy.accountsample.ui.register.presenter

import android.text.TextUtils
import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import tech.raynaldy.accountsample.data.database.repository.User.User
import tech.raynaldy.accountsample.ui.base.presenter.BasePresenter
import tech.raynaldy.accountsample.ui.login.interactor.LoginMvpInteractor
import tech.raynaldy.accountsample.ui.login.presenter.LoginMvpPresenter
import tech.raynaldy.accountsample.ui.login.view.LoginMvpView
import tech.raynaldy.accountsample.ui.register.interactor.RegisterMvpInteractor
import tech.raynaldy.accountsample.ui.register.view.RegisterMvpView
import tech.raynaldy.accountsample.util.SchedulerProvider
import javax.inject.Inject


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */


class RegisterPresenter<V: RegisterMvpView, I: RegisterMvpInteractor>
@Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) :
    BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable),
    RegisterMvpPresenter<V, I> {
    override fun onAttach(view: V?) {
        super.onAttach(view)

    }

    override fun registerUser(user: User) {
        insertUser(user)
    }

    private fun insertUser(user: User) = interactor?.let {
        compositeDisposable.add(it.insertUser(user)
            .compose(schedulerProvider.ioToMainObservableScheduler())
            .subscribe({
                if (it) getView()?.onRegisterFinished()
            }, { err -> Log.e("TAG", "insertUser: ", err) }
            )
        )
    }

    override fun isEmailValid(email: String): Boolean {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun isPhoneValid(phone: String): Boolean {
        return !TextUtils.isEmpty(phone) && android.util.Patterns.PHONE.matcher(phone).matches();
    }

    override fun isPasswordValid(password: String?) : Boolean {

        var isValid = false

        password?.let {
            val passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@\$!\\-.%*#?&])[A-Za-z\\d@\$\\-.!%*#?&]{8,}"
            val passwordMatcher = Regex(passwordPattern)

            isValid = passwordMatcher.find(password) != null
        }

        return isValid && !isNoOrderNumber(password)
    }

    fun isNoOrderNumber(password: String?) : Boolean {
        var count = 0
        var lastDigit = -2
        password?.forEach {
            if (it.isDigit()) {
                if (it.toInt() - lastDigit == 1) count++
                else {
                    count = 0
                }
                lastDigit = it.toInt()

                if (count >= 2) return true
            } else count = 0
        }
        return count >= 2
    }

}