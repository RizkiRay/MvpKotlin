package tech.raynaldy.accountsample.util

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 2/25/21.
 */

class SchedulerProvider {
    fun <T> ioToMainObservableScheduler(): ObservableTransformer<T, T> = ObservableTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
            .observeOn(getMainThreadScheduler())
}

    fun <T> ioToMainSingleScheduler(): SingleTransformer<T, T> = SingleTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
            .observeOn(getMainThreadScheduler())
    }


    fun ioToMainCompletableScheduler(): CompletableTransformer = CompletableTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
            .observeOn(getMainThreadScheduler())
    }


    fun <T> ioToMainFlowableScheduler(): FlowableTransformer<T, T> = FlowableTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
            .observeOn(getMainThreadScheduler())
    }


    fun <T> ioToMainMaybeScheduler(): MaybeTransformer<T, T> = MaybeTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
            .observeOn(getMainThreadScheduler())
    }

    private fun getIOThreadScheduler() = Schedulers.io()

    private fun getMainThreadScheduler() = AndroidSchedulers.mainThread()
}