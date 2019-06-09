package com.tech.foodie.techfoodie.model.dto.city;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {

  @SerializedName("id")
  @Expose
  public int id;
  @SerializedName("name")
  @Expose
  public String name;
  @SerializedName("country_id")
  @Expose
  public int countryId;
  @SerializedName("country_name")
  @Expose
  public String countryName;
  @SerializedName("country_flag_url")
  @Expose
  public String countryFlagUrl;
  @SerializedName("should_experiment_with")
  @Expose
  public int shouldExperimentWith;
  @SerializedName("discovery_enabled")
  @Expose
  public int discoveryEnabled;
  @SerializedName("has_new_ad_format")
  @Expose
  public int hasNewAdFormat;
  @SerializedName("is_state")
  @Expose
  public int isState;
  @SerializedName("state_id")
  @Expose
  public int stateId;
  @SerializedName("state_name")
  @Expose
  public String stateName;
  @SerializedName("state_code")
  @Expose
  public String stateCode;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
