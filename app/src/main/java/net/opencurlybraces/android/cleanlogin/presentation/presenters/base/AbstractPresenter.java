package net.opencurlybraces.android.cleanlogin.presentation.presenters.base;


import net.opencurlybraces.android.cleanlogin.domain.executor.Executor;
import net.opencurlybraces.android.cleanlogin.domain.executor.MainThread;

/**
 * This is a base class for all presenters which are communicating with interactors. This base class will hold a
 * reference to the Executor and MainThread objects that are needed for running interactors in a background thread.
 */
public abstract class AbstractPresenter {
    protected Executor mExecutor;
    protected MainThread mMainThread;

    public AbstractPresenter(Executor executor, MainThread mainThread) {
        mExecutor = executor;
        mMainThread = mainThread;
    }
}
