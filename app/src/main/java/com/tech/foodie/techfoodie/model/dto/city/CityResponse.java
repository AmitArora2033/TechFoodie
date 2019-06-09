package com.tech.foodie.techfoodie.model.dto.city;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CityResponse {

  @SerializedName("location_suggestions")
  @Expose
  private List<City> cities = null;
  @SerializedName("status")
  @Expose
  private String status;
  @SerializedName("has_more")
  @Expose
  private int hasMore;
  @SerializedName("has_total")
  @Expose
  private int hasTotal;

  public List<City> getLocationSuggestions() {
    return cities;
  }

  public String getStatus() {
    return status;
  }

  public int getHasMore() {
    return hasMore;
  }

  public int getHasTotal() {
    return hasTotal;
  }
}
