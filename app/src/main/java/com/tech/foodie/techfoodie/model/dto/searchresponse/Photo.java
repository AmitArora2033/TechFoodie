package com.tech.foodie.techfoodie.model.dto.searchresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo {

  @SerializedName("photo")
  @Expose
  private Photo_ photo;

  public Photo_ getPhoto() {
    return photo;
  }
}
