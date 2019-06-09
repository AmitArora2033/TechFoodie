package com.tech.foodie.techfoodie.model.domain;

import com.google.auto.value.AutoValue;
import java.util.List;

@AutoValue public abstract class SearchResponse {

  public static SearchResponse create(int resultFound, int resultStart, int resultShown,
      List<Restaurant> restaurantList) {
    return new AutoValue_SearchResponse(resultFound, resultStart, resultShown, restaurantList);
  }

  public abstract int resultFound();

  public abstract int resultStart();

  public abstract int resultShown();

  public abstract List<Restaurant> restaurantList();
}
