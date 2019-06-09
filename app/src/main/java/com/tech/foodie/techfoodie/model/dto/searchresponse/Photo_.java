package com.tech.foodie.techfoodie.model.dto.searchresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo_ {

  public String getUrl() {
    return url;
  }

  public String getThumbUrl() {
    return thumbUrl;
  }

  public int getOrder() {
    return order;
  }

  public String getMd5sum() {
    return md5sum;
  }

  public long getId() {
    return id;
  }

  public long getPhotoId() {
    return photoId;
  }

  public long getUuid() {
    return uuid;
  }

  public String getType() {
    return type;
  }

  @SerializedName("url")
  @Expose
  private String url;
  @SerializedName("thumb_url")
  @Expose
  private String thumbUrl;
  @SerializedName("order")
  @Expose
  private int order;
  @SerializedName("md5sum")
  @Expose
  private String md5sum;
  @SerializedName("id")
  @Expose
  private long id;
  @SerializedName("photo_id")
  @Expose
  private long photoId;
  @SerializedName("uuid")
  @Expose
  private long uuid;
  @SerializedName("type")
  @Expose
  private String type;

}
