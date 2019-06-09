package com.tech.foodie.techfoodie.view.home;

import android.util.Log;
import com.tech.foodie.techfoodie.R;
import com.tech.foodie.techfoodie.base.BasePresenter;
import com.tech.foodie.techfoodie.remote.service.DataManager;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class AppPresenter extends BasePresenter<AppView> {

  private final DataManager dataManager;

  @Inject public AppPresenter(DataManager dataManager) {
    this.dataManager = dataManager;
  }

  public void getCity(double latitiude, double longitude) {
    getCompositeDisosable().add(dataManager.getCityFromLatLong(latitiude, longitude)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread()).subscribe(cities -> {
          view.showCities(cities);
        }, throwable -> {
          if (isViewAttached()) {
            view.showToast(R.string.unknown_error_occurred);
          }
          Log.e(TAG, throwable.getMessage());
        }));
  }
}
