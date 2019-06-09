package com.tech.foodie.techfoodie.remote.service;

import com.tech.foodie.techfoodie.model.dto.city.CityResponse;
import com.tech.foodie.techfoodie.model.dto.location.LocationResponse;
import com.tech.foodie.techfoodie.model.dto.searchresponse.SearchResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface RemoteService {

  @GET("locations") Observable<LocationResponse> getLocations(@Header("user-key") String userKey,
      @Query("query") String query);

  @GET("search") Observable<SearchResponse> searchRestaurants(@Header("user-key") String userKey,
      @Query("entity_id") int entityId,
      @Query("entity_type") String entityType,
      @Query("q") String searchKeyword, @Query("start") int startOffset, @Query("count") int count,
      @Query("lat") double lat, @Query("lon") double lon,
      @Query("radius") double radiousAreaInmeter);

  @GET("search") Observable<SearchResponse> searchRestaurants(@Header("user-key") String userKey,
      @Query("q") String searchKeyword, @Query("start") int startOffset, @Query("count") int count);

  @GET("cities") Observable<CityResponse> getCityForLatLon(
      @Header("user-key") String apiKey,
      @Query("lat") double lat, @Query("lon") double lon);
}

