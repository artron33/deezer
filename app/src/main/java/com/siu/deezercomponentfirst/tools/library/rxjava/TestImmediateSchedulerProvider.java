package com.siu.deezercomponentfirst.tools.library.rxjava;

import androidx.annotation.NonNull;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Implementation of the {@link BaseSchedulerProvider} making all {@link Scheduler}s immediate.
 */
public class TestImmediateSchedulerProvider implements BaseSchedulerProvider {

    @NonNull
    @Override
    public Scheduler computation() {
        return Schedulers.trampoline();
    }

    @NonNull
    @Override
    public Scheduler io() {
        return Schedulers.trampoline();
    }

    @NonNull
    @Override
    public Scheduler ui() {
        return Schedulers.trampoline();
    }
}
