package com.tech.foodie.techfoodie.model;

import android.util.Log;
import com.tech.foodie.techfoodie.model.dto.searchresponse.Location;
import com.tech.foodie.techfoodie.model.dto.searchresponse.Restaurant;
import com.tech.foodie.techfoodie.model.dto.searchresponse.Restaurant_;
import com.tech.foodie.techfoodie.model.dto.searchresponse.SearchResponse;
import com.tech.foodie.techfoodie.model.dto.searchresponse.UserRating;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DomainMapper {

  public static Function<SearchResponse, com.tech.foodie.techfoodie.model.domain.SearchResponse>

  mapSearchDtoToSearchDomain() {
    return searchResponse -> {

      List<com.tech.foodie.techfoodie.model.domain.Restaurant> restaurantList = new ArrayList<>();
      for (Restaurant resto : searchResponse.getRestaurants()) {

        try {

          Restaurant_ restaurant = resto.getRestaurant();
          UserRating rating = restaurant.getUserRating();
          Location loc = restaurant.getLocation();

          com.tech.foodie.techfoodie.model.domain.Restaurant.UserRating userRating =
              com.tech.foodie.techfoodie.model.domain.Restaurant.UserRating.create(
                  rating.getAggregateRating(), rating.getRatingText(), rating.getRatingColor(),
                  rating.getVotes());

          com.tech.foodie.techfoodie.model.domain.Restaurant.Location location =
              com.tech.foodie.techfoodie.model.domain.Restaurant.Location.create(loc.getAddress(),
                  loc.getLocality(), loc.getCity(),
                  loc.getLatitude() != null && loc.getLatitude().length() > 0 ? Double.parseDouble(
                      loc.getLatitude()) : 0,
                  loc.getLongitude() != null && loc.getLongitude().length() > 0 ?
                      Double.parseDouble(loc.getLongitude()) : 0, loc.getZipcode(),
                  loc.getCountryId());

          restaurantList.add(
              com.tech.foodie.techfoodie.model.domain.Restaurant.create(
                  restaurant.getId() != null && restaurant.getId().length() > 0 ?
                      Long.parseLong(restaurant.getId()) : 0,
                  restaurant.getName(), location, restaurant.getFeaturedImage(),
                  restaurant.getAverageCostForTwo(), restaurant.getCurrency(), userRating,
                  restaurant.getHasOnlineDelivery() == 1, restaurant.getDeeplink(),
                  restaurant.getCuisines()));
        }catch (Exception e){
          Log.e("Exception",  e.toString());
        }
      }

      return com.tech.foodie.techfoodie.model.domain.SearchResponse.create(
          searchResponse.getResultsFound(), searchResponse.getResultsStart(),
          searchResponse.getResultsShown(), restaurantList);
    };
  }
}
