package com.tech.foodie.techfoodie.model.dto.searchresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Event {

  @SerializedName("event_id")
  @Expose
  private int eventId;
  @SerializedName("friendly_start_date")
  @Expose
  private String friendlyStartDate;
  @SerializedName("friendly_end_date")
  @Expose
  private String friendlyEndDate;
  @SerializedName("friendly_timing_str")
  @Expose
  private String friendlyTimingStr;
  @SerializedName("start_date")
  @Expose
  private String startDate;
  @SerializedName("end_date")
  @Expose
  private String endDate;
  @SerializedName("end_time")
  @Expose
  private String endTime;
  @SerializedName("start_time")
  @Expose
  private String startTime;
  @SerializedName("is_active")
  @Expose
  private int isActive;
  @SerializedName("date_added")
  @Expose
  private String dateAdded;
  @SerializedName("photos")
  @Expose
  private List<Photo> photos = null;
  @SerializedName("restaurants")
  @Expose
  private List<Object> restaurants = null;
  @SerializedName("is_valid")
  @Expose
  private int isValid;
  @SerializedName("share_url")
  @Expose
  private String shareUrl;
  @SerializedName("show_share_url")
  @Expose
  private int showShareUrl;
  @SerializedName("title")
  @Expose
  private String title;
  @SerializedName("description")
  @Expose
  private String description;
  @SerializedName("display_time")
  @Expose
  private String displayTime;
  @SerializedName("display_date")
  @Expose
  private String displayDate;
  @SerializedName("is_end_time_set")
  @Expose
  private int isEndTimeSet;
  @SerializedName("disclaimer")
  @Expose
  private String disclaimer;
  @SerializedName("event_category")
  @Expose
  private int eventCategory;
  @SerializedName("event_category_name")
  @Expose
  private String eventCategoryName;
  @SerializedName("book_link")
  @Expose
  private String bookLink;
  @SerializedName("types")
  @Expose
  private List<Type> types = null;
  @SerializedName("share_data")
  @Expose
  private ShareData shareData;
  @SerializedName("is_zomato_event")
  @Expose
  private boolean isZomatoEvent;
  @SerializedName("url")
  @Expose
  private String url;

  public int getEventId() {
    return eventId;
  }

  public String getFriendlyStartDate() {
    return friendlyStartDate;
  }

  public String getFriendlyEndDate() {
    return friendlyEndDate;
  }

  public String getFriendlyTimingStr() {
    return friendlyTimingStr;
  }

  public String getStartDate() {
    return startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public String getEndTime() {
    return endTime;
  }

  public String getStartTime() {
    return startTime;
  }

  public int getIsActive() {
    return isActive;
  }

  public String getDateAdded() {
    return dateAdded;
  }

  public List<Photo> getPhotos() {
    return photos;
  }

  public List<Object> getRestaurants() {
    return restaurants;
  }

  public int getIsValid() {
    return isValid;
  }

  public String getShareUrl() {
    return shareUrl;
  }

  public int getShowShareUrl() {
    return showShareUrl;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public String getDisplayTime() {
    return displayTime;
  }

  public String getDisplayDate() {
    return displayDate;
  }

  public int getIsEndTimeSet() {
    return isEndTimeSet;
  }

  public String getDisclaimer() {
    return disclaimer;
  }

  public int getEventCategory() {
    return eventCategory;
  }

  public String getEventCategoryName() {
    return eventCategoryName;
  }

  public String getBookLink() {
    return bookLink;
  }

  public List<Type> getTypes() {
    return types;
  }

  public ShareData getShareData() {
    return shareData;
  }

  public boolean isZomatoEvent() {
    return isZomatoEvent;
  }

  public String getUrl() {
    return url;
  }
}
