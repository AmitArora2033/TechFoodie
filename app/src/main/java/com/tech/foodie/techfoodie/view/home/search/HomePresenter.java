package com.tech.foodie.techfoodie.view.home.search;

import android.util.Log;
import com.tech.foodie.techfoodie.R;
import com.tech.foodie.techfoodie.base.BasePresenter;
import com.tech.foodie.techfoodie.model.domain.City;
import com.tech.foodie.techfoodie.model.domain.Location;
import com.tech.foodie.techfoodie.remote.service.DataManager;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

public class HomePresenter extends BasePresenter<HomeView> {

  private static final String TAG = HomePresenter.class.getSimpleName();
  private final DataManager dataManager;

  @Inject
  public HomePresenter(DataManager dataManager) {
    this.dataManager = dataManager;
  }

  public void getRestaurantsList(String searchQuery, Location location, int count, int startOffset
  ) {

    getCompositeDisosable().add(
        dataManager.getRestaturantList(searchQuery, location, count, startOffset)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(searchResponse -> {
              if (isViewAttached()) {
                view.showRestaurantList(searchResponse.restaurantList());
              }
            }, throwable -> {
              Log.e(TAG, throwable.toString());
              throwable.printStackTrace();
            }));
  }

  public void getLocation(City city) {
    getCompositeDisosable().add(dataManager.getLocationFromCity(city)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(locations -> {
          if (isViewAttached()) {
            view.showLocation(locations);
          }
        }, throwable -> {
          if (isViewAttached()) {
            view.showToast(R.string.unknown_error_occurred);
          }
          Log.e(TAG, throwable.getMessage());
        }));
  }
}