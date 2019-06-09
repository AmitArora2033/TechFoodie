package com.tech.foodie.techfoodie.remote.service;

import com.tech.foodie.techfoodie.model.DomainMapper;
import com.tech.foodie.techfoodie.model.domain.City;
import com.tech.foodie.techfoodie.model.domain.Location;
import com.tech.foodie.techfoodie.model.domain.SearchResponse;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;

public class ApiManager {

  public static final String API_KEY = "0c9a19efbd444434acc14a7ef7407e7e";
  private final RemoteService remoteService;

  public ApiManager(RemoteService service) {
    this.remoteService = service;
  }

  public Observable<SearchResponse> getRestaurantList(
      Location location, String searchKey, int count, int startOffset) {
    if (location != null) {
      return remoteService.searchRestaurants(API_KEY, location.entityId(), location.entityType(),
          searchKey,
          startOffset, count, location.lat(), location.lon(),
          2000).map(DomainMapper.mapSearchDtoToSearchDomain());
    }

    return remoteService.searchRestaurants(API_KEY, searchKey, startOffset,
        count).map(DomainMapper.mapSearchDtoToSearchDomain());
  }

  public Observable<List<City>> getCityFromLatLong(double lat, double lon) {
    return remoteService.getCityForLatLon(API_KEY, lat, lon).map(cityResponse -> {
      List<City> cities = new ArrayList<>();
      if (cityResponse.getStatus().equals("success")) {

        for (com.tech.foodie.techfoodie.model.dto.city.City city : cityResponse.getLocationSuggestions()) {
          cities.add(City.create(city.getId(), city.getName()));
        }
      }
      return cities;
    });
  }

  public Observable<List<Location>> getLocation(String query) {
    return remoteService.getLocations(API_KEY, query).map(locationResponse -> {
      List<Location> locationList = new ArrayList<>();
      if (locationResponse.getStatus().equalsIgnoreCase("success")) {

        for (com.tech.foodie.techfoodie.model.dto.location.Location location : locationResponse.getLocationSuggestions()) {
          locationList.add(
              Location.create(location.getEntityId(), location.getEntityType(), location.getTitle(),
                  location.getLatitude(), location.getLongitude(), location.getCityId(),
                  location.getCityName(), location.getCountryId(), location.getCountryName()));
        }
      }
      return locationList;
    });
  }
}
