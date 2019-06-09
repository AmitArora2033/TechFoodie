package com.tech.foodie.techfoodie.model.dto.searchresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ZomatoEvent {

  @SerializedName("event")
  @Expose
  private Event event;

  public Event getEvent() {
    return event;
  }
}
