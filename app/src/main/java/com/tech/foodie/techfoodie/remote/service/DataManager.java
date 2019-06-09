package com.tech.foodie.techfoodie.remote.service;

import com.tech.foodie.techfoodie.model.domain.City;
import com.tech.foodie.techfoodie.model.domain.Location;
import com.tech.foodie.techfoodie.model.domain.SearchResponse;
import io.reactivex.Observable;
import java.util.List;

public class DataManager {

  private final ApiManager apiManager;

  public DataManager(ApiManager apiManager) {
    this.apiManager = apiManager;
  }

  public Observable<SearchResponse> getRestaturantList(String searchKey, Location location,
      int count, int startOffset) {

    return apiManager.getRestaurantList(location, searchKey, count, startOffset);
  }

  public Observable<List<City>> getCityFromLatLong(double lat, double lon) {
    return apiManager.getCityFromLatLong(lat, lon);
  }

  public Observable<List<Location>> getLocationFromCity(City city) {
    return apiManager.getLocation(city.cityName());
  }
}
