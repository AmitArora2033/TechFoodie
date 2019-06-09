package com.tech.foodie.techfoodie.model.dto.searchresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Type {

  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("color")
  @Expose
  private String color;

  public String getName() {
    return name;
  }

  public String getColor() {
    return color;
  }
}
