package com.tech.foodie.techfoodie.model.dto.searchresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SearchResponse {

  @SerializedName("results_found")
  @Expose
  private int resultsFound;
  @SerializedName("results_start")
  @Expose
  private int resultsStart;
  @SerializedName("results_shown")
  @Expose
  private int resultsShown;
  @SerializedName("restaurants")
  @Expose
  private List<Restaurant> restaurants = null;

  public int getResultsFound() {
    return resultsFound;
  }

  public int getResultsStart() {
    return resultsStart;
  }

  public int getResultsShown() {
    return resultsShown;
  }

  public List<Restaurant> getRestaurants() {
    return restaurants;
  }
}


