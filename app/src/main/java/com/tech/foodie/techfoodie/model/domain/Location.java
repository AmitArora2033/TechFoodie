package com.tech.foodie.techfoodie.model.domain;

import com.google.auto.value.AutoValue;

@AutoValue public abstract class Location {

  public static Location create(int entityId, String entityType, String title, double lat,
      double lon, int cityId, String cityName, int countryId, String countryName) {
    return new AutoValue_Location(entityId, entityType, title, lat, lon, cityId, cityName,
        countryId, countryName);
  }

  public abstract int entityId();

  public abstract String entityType();

  public abstract String title();

  public abstract double lat();

  public abstract double lon();

  public abstract int cityId();

  public abstract String cityName();

  public abstract int countryId();

  public abstract String countryName();
}
