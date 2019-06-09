package com.tech.foodie.techfoodie.view.home;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import com.tech.foodie.techfoodie.App;
import com.tech.foodie.techfoodie.R;
import com.tech.foodie.techfoodie.base.BaseActivity;
import com.tech.foodie.techfoodie.model.domain.City;
import com.tech.foodie.techfoodie.model.domain.Restaurant;
import com.tech.foodie.techfoodie.view.home.search.HomeFragment;
import com.tech.foodie.techfoodie.view.home.restaurantdetail.RestaurantDetailFragment;
import java.util.List;
import javax.inject.Inject;

public class AppActivity extends BaseActivity implements AppView {

  private static final String USER_CITY = "user_city";
  @Inject AppPresenter presenter;
  @BindView(R.id.toolbar) androidx.appcompat.widget.Toolbar toolbar;

  private double userLat;
  private double userLong;
  private City city;
  private HomeFragment homeFragment;

  @Override protected void locationPermissionGranted() {
    getLocation();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_app);
  }

  @Override public void initDependencies() {
    App.getAppComponent().inject(this);
    presenter.attachView(this);
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
  }

  @Override public void destroyPresenter() {
    presenter.detachView();
  }

  @Override public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    outState.putParcelable(USER_CITY, city);
    super.onSaveInstanceState(outState, outPersistentState);
  }

  @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
    city = savedInstanceState.getParcelable(USER_CITY);
    super.onRestoreInstanceState(savedInstanceState);
  }

  @Override public void onReady() {
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayShowTitleEnabled(false);
    homeFragment = HomeFragment.newInstance();
    addFragment(homeFragment);
    getLocation();
  }

  public void getLocation() {
    if (checkHasLocationPermission()) {
      LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

      locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 100, 1000,
          new LocationListener() {

            @Override public void onLocationChanged(Location loc) {
              userLat = loc.getLatitude();
              userLong = loc.getLongitude();
              presenter.getCity(userLat, userLong);
            }

            @Override public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override public void onProviderEnabled(String provider) {

            }

            @Override public void onProviderDisabled(String provider) {

            }
          });
    } else {
      getLocationPermission();
    }
  }

  public void openRestaurantDetails(Restaurant restaurant) {
    RestaurantDetailFragment fragment = RestaurantDetailFragment.newInstance(restaurant);
    addFragment(fragment);
  }

  private void replaceFragment(Fragment fragment) {
    getSupportFragmentManager().beginTransaction()
        .addToBackStack(Fragment.class.getName())
        .setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
        .replace(R.id.frame_layout, fragment, "current_fragment").commit();
  }

  private void addFragment(Fragment fragment) {
    getSupportFragmentManager().beginTransaction()
        .addToBackStack(Fragment.class.getName())
        .setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
        .add(R.id.frame_layout, fragment, "current_fragment").commit();
  }

  @Override public void onBackPressed() {
    if (getSupportFragmentManager().getFragments().size() > 1) {
      getSupportFragmentManager().popBackStack();
    }

    getSupportFragmentManager().addOnBackStackChangedListener(
        () -> {
          if (getSupportFragmentManager().getFragments().size() <= 1) {
            finish();
          }
        });
  }

  @Override public void showError(String errorMessage) {

  }

  @Override public void showContent() {

  }

  @Override public void showProgress() {

  }

  public City getCity() {
    return city;
  }

  @Override public void showCities(List<City> cities) {
    if (cities != null && cities.size() > 0) {
      this.city = cities.get(0);
      if (homeFragment != null) {
        homeFragment.setUserCurrentCity(city);
      }
    }
  }
}
