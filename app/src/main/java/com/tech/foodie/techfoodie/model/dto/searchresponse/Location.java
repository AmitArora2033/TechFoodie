package com.tech.foodie.techfoodie.model.dto.searchresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

  @SerializedName("address")
  @Expose
  private String address;
  @SerializedName("locality")
  @Expose
  private String locality;
  @SerializedName("city")
  @Expose
  private String city;
  @SerializedName("city_id")
  @Expose
  private int cityId;
  @SerializedName("latitude")
  @Expose
  private String latitude;
  @SerializedName("longitude")
  @Expose
  private String longitude;
  @SerializedName("zipcode")
  @Expose
  private String zipcode;
  @SerializedName("country_id")
  @Expose
  private int countryId;
  @SerializedName("locality_verbose")
  @Expose
  private String localityVerbose;

  public String getAddress() {
    return address;
  }

  public String getLocality() {
    return locality;
  }

  public String getCity() {
    return city;
  }

  public int getCityId() {
    return cityId;
  }

  public String getLatitude() {
    return latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public String getZipcode() {
    return zipcode;
  }

  public int getCountryId() {
    return countryId;
  }

  public String getLocalityVerbose() {
    return localityVerbose;
  }
}
