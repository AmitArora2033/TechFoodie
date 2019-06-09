package com.tech.foodie.techfoodie.model.dto.searchresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShareData {

  @SerializedName("should_show")
  @Expose
  private int shouldShow;

  public int getShouldShow() {
    return shouldShow;
  }
}
