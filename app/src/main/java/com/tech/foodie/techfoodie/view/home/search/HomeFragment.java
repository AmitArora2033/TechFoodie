package com.tech.foodie.techfoodie.view.home.search;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.jakewharton.rxbinding3.widget.RxTextView;
import com.tech.foodie.techfoodie.App;
import com.tech.foodie.techfoodie.R;
import com.tech.foodie.techfoodie.base.BaseFragment;
import com.tech.foodie.techfoodie.model.domain.City;
import com.tech.foodie.techfoodie.model.domain.Location;
import com.tech.foodie.techfoodie.model.domain.Restaurant;
import com.tech.foodie.techfoodie.view.home.AppActivity;
import com.tech.foodie.techfoodie.view.home.adapter.RestaurantAdapter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

public class HomeFragment extends BaseFragment
    implements HomeView {

  private static final String BUNDLE_RESTAURANTS = "bundle_restaurants";
  private static final String BUNDLE_SEARCH_QUERY = "bundle_search_query";
  private static final String DEFAULT_SEARCH = "Biryani";
  @BindView(R.id.rcv_restaurants) RecyclerView recyclerView;
  @BindView(R.id.et_search_text) EditText etSearch;

  @Inject HomePresenter presenter;
  private RestaurantAdapter adapter;
  private ArrayList<Restaurant> restaurants;
  private Location location;

  public static HomeFragment newInstance() {

    Bundle args = new Bundle();

    HomeFragment fragment = new HomeFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override protected void detachView() {
    presenter.detachView();
  }

  @Override public int getContentLayout() {
    return R.layout.layout_restaurant_serarch;
  }

  @Override protected void initDependencies() {
    App.getAppComponent().inject(this);
    presenter.attachView(this);
  }

  @Override protected void onReady(Bundle savedInstanceState) {
    adapter = new RestaurantAdapter(getContext(), this::openRestaurantDetails);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setAdapter(adapter);

    if (((AppActivity) getActivity()).getCity() == null) {
      ((AppActivity) getActivity()).getLocation();
    } else {
      presenter.getLocation(((AppActivity) getActivity()).getCity());
    }

    if (savedInstanceState != null
        && savedInstanceState.getParcelable(BUNDLE_RESTAURANTS) != null) {
      restaurants = savedInstanceState.getParcelable(BUNDLE_RESTAURANTS);
      adapter.setRestaurantData(restaurants);
      etSearch.setText(savedInstanceState.getString(BUNDLE_SEARCH_QUERY));
    } else {
      loadRestaurantList(DEFAULT_SEARCH);
    }

    RxTextView.textChangeEvents(etSearch)
        .debounce(200, TimeUnit.MILLISECONDS)
        .distinctUntilChanged()
        .observeOn(AndroidSchedulers.mainThread())
        .doOnError(throwable -> {
          Log.e("Error", throwable.getMessage());
        })
        .switchMap(charSequence -> {
          String search = charSequence.getView().getEditableText().toString();
          if (search.length() > 0) {
            loadRestaurantList(charSequence.getView().getEditableText().toString());
          } else {
            loadRestaurantList(DEFAULT_SEARCH);
          }
          return Observable.just(charSequence.getText());
        })
        .subscribe();
  }

  @Override public void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(BUNDLE_RESTAURANTS, restaurants);
    outState.putString(BUNDLE_SEARCH_QUERY, etSearch.getText().toString());
  }

  private void loadRestaurantList(String s) {
    presenter.getRestaurantsList(s, location, 20, 1);
  }

  private void openRestaurantDetails(Restaurant restaurant) {
    ((AppActivity) getActivity()).openRestaurantDetails(restaurant);
  }

  @Override public void showRestaurantList(List<Restaurant> restaurants) {
    this.restaurants = (ArrayList) restaurants;
    adapter.setRestaurantData(this.restaurants);
    adapter.notifyDataSetChanged();
  }

  @Override public void showLocation(List<Location> locations) {
    this.location = locations.get(0);
    loadRestaurantList(etSearch.getText().toString().length() > 0 ? etSearch.getText().toString()
        : DEFAULT_SEARCH);
  }

  @Override public void showCities(List<City> cities) {

  }

  public void setUserCurrentCity(City city) {
    if (presenter != null) {
      presenter.getLocation(city);
    }
  }
}
