package com.tech.foodie.techfoodie.model.domain;

import android.os.Parcelable;
import com.google.auto.value.AutoValue;

@AutoValue public abstract class Restaurant  implements Parcelable {

  public static Restaurant create(long restaurantId, String restaurantName,
      Location location, String imageUrl, double avgCostForTwo, String currency,
      UserRating userRating, boolean hasOnlineDelivery, String deepLink, String cusines) {
    return new AutoValue_Restaurant(restaurantId, restaurantName, location, imageUrl, avgCostForTwo,
        currency, userRating, hasOnlineDelivery, deepLink, cusines);
  }

  public abstract long restaurantId();

  public abstract String restaurantName();

  public abstract Location location();

  public abstract String imageUrl();

  public abstract double avgCostForTwo();

  public abstract String currency();

  public abstract UserRating uSerRating();

  public abstract boolean hasOnlineDelivery();

  public abstract String deepLink();

  public abstract String cusines();


  @AutoValue public  abstract static class Location implements Parcelable {

    public static Location create(String address, String locality, String city, double lat,
        double lon, String zipCode, int countryId) {
      return new AutoValue_Restaurant_Location(address, locality, city, lat, lon, zipCode,
          countryId);
    }

    public abstract String address();

    public abstract String locality();

    public abstract String city();

    public abstract double lat();

    public abstract double lon();

    public abstract String zipCode();

    public abstract int countryId();
  }

  @AutoValue public static  abstract class UserRating  implements Parcelable{
    public static UserRating create(String aggregateRating, String ratingText, String ratingColor,
        String votes) {
      return new AutoValue_Restaurant_UserRating(aggregateRating, ratingText, ratingColor, votes);
    }

    public abstract String aggregateRating();

    public abstract String ratingText();

    public abstract String ratingColor();

    public abstract String votes();
  }
}
