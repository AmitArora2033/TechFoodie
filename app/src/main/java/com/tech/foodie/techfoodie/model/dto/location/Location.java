package com.tech.foodie.techfoodie.model.dto.location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

  @SerializedName("entity_type")
  @Expose
  private String entityType;
  @SerializedName("entity_id")
  @Expose
  private int entityId;
  @SerializedName("title")
  @Expose
  private String title;
  @SerializedName("latitude")
  @Expose
  private double latitude;
  @SerializedName("longitude")
  @Expose
  private double longitude;
  @SerializedName("city_id")
  @Expose
  private int cityId;
  @SerializedName("city_name")
  @Expose
  private String cityName;
  @SerializedName("country_id")
  @Expose
  private int countryId;
  @SerializedName("country_name")
  @Expose
  private String countryName;

  public String getEntityType() {
    return entityType;
  }

  public int getEntityId() {
    return entityId;
  }

  public String getTitle() {
    return title;
  }

  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public int getCityId() {
    return cityId;
  }

  public String getCityName() {
    return cityName;
  }

  public int getCountryId() {
    return countryId;
  }

  public String getCountryName() {
    return countryName;
  }
}


