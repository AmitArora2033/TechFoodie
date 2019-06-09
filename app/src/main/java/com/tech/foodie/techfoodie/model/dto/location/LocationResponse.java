package com.tech.foodie.techfoodie.model.dto.location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class LocationResponse {

  @SerializedName("location_suggestions")
  @Expose
  public List<Location> locationSuggestions = null;
  @SerializedName("status")
  @Expose
  public String status;
  @SerializedName("has_more")
  @Expose
  public int hasMore;
  @SerializedName("has_total")
  @Expose
  public int hasTotal;

  public List<Location> getLocationSuggestions() {
    return locationSuggestions;
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
