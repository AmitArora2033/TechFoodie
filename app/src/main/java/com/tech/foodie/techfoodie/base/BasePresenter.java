package com.tech.foodie.techfoodie.base;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<V extends BaseView> {

  protected V view;

  private CompositeDisposable compositeDisposable;

  public void attachView(V view) {
    this.view = view;
  }

  protected boolean isViewAttached() {
    return this.view != null;
  }

  protected CompositeDisposable getCompositeDisosable() {
    if (compositeDisposable == null) {
      return new CompositeDisposable();
    }
    return compositeDisposable;
  }

  public void detachView() {
    if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
      compositeDisposable.dispose();
    }
    view = null;
  }
}