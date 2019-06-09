package com.tech.foodie.techfoodie.model.dto.searchresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Restaurant_ {

  @SerializedName("R")
  @Expose
  private R r;
  @SerializedName("apikey")
  @Expose
  private String apikey;
  @SerializedName("id")
  @Expose
  private String id;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("url")
  @Expose
  private String url;
  @SerializedName("location")
  @Expose
  private Location location;
  @SerializedName("switch_to_order_menu")
  @Expose
  private int switchToOrderMenu;
  @SerializedName("cuisines")
  @Expose
  private String cuisines;
  @SerializedName("average_cost_for_two")
  @Expose
  private int averageCostForTwo;
  @SerializedName("price_range")
  @Expose
  private int priceRange;
  @SerializedName("currency")
  @Expose
  private String currency;
  @SerializedName("offers")
  @Expose
  private List<Object> offers = null;
  @SerializedName("zomato_events")
  @Expose
  private List<ZomatoEvent> zomatoEvents = null;
  @SerializedName("opentable_support")
  @Expose
  private int opentableSupport;
  @SerializedName("is_zomato_book_res")
  @Expose
  private int isZomatoBookRes;
  @SerializedName("mezzo_provider")
  @Expose
  private String mezzoProvider;
  @SerializedName("is_book_form_web_view")
  @Expose
  private int isBookFormWebView;
  @SerializedName("book_form_web_view_url")
  @Expose
  private String bookFormWebViewUrl;
  @SerializedName("book_again_url")
  @Expose
  private String bookAgainUrl;
  @SerializedName("thumb")
  @Expose
  private String thumb;
  @SerializedName("user_rating")
  @Expose
  private UserRating userRating;
  @SerializedName("photos_url")
  @Expose
  private String photosUrl;
  @SerializedName("menu_url")
  @Expose
  private String menuUrl;
  @SerializedName("featured_image")
  @Expose
  private String featuredImage;
  @SerializedName("medio_provider")
  @Expose
  private int medioProvider;
  @SerializedName("has_online_delivery")
  @Expose
  private int hasOnlineDelivery;
  @SerializedName("is_delivering_now")
  @Expose
  private int isDeliveringNow;
  @SerializedName("include_bogo_offers")
  @Expose
  private boolean includeBogoOffers;
  @SerializedName("deeplink")
  @Expose
  private String deeplink;
  @SerializedName("order_url")
  @Expose
  private String orderUrl;
  @SerializedName("order_deeplink")
  @Expose
  private String orderDeeplink;
  @SerializedName("is_table_reservation_supported")
  @Expose
  private int isTableReservationSupported;
  @SerializedName("has_table_booking")
  @Expose
  private int hasTableBooking;
  @SerializedName("book_url")
  @Expose
  private String bookUrl;
  @SerializedName("events_url")
  @Expose
  private String eventsUrl;
  @SerializedName("establishment_types")
  @Expose
  private List<Object> establishmentTypes = null;

  public R getR() {
    return r;
  }

  public String getApikey() {
    return apikey;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getUrl() {
    return url;
  }

  public Location getLocation() {
    return location;
  }

  public int getSwitchToOrderMenu() {
    return switchToOrderMenu;
  }

  public String getCuisines() {
    return cuisines;
  }

  public int getAverageCostForTwo() {
    return averageCostForTwo;
  }

  public int getPriceRange() {
    return priceRange;
  }

  public String getCurrency() {
    return currency;
  }

  public List<Object> getOffers() {
    return offers;
  }

  public List<ZomatoEvent> getZomatoEvents() {
    return zomatoEvents;
  }

  public int getOpentableSupport() {
    return opentableSupport;
  }

  public int getIsZomatoBookRes() {
    return isZomatoBookRes;
  }

  public String getMezzoProvider() {
    return mezzoProvider;
  }

  public int getIsBookFormWebView() {
    return isBookFormWebView;
  }

  public String getBookFormWebViewUrl() {
    return bookFormWebViewUrl;
  }

  public String getBookAgainUrl() {
    return bookAgainUrl;
  }

  public String getThumb() {
    return thumb;
  }

  public UserRating getUserRating() {
    return userRating;
  }

  public String getPhotosUrl() {
    return photosUrl;
  }

  public String getMenuUrl() {
    return menuUrl;
  }

  public String getFeaturedImage() {
    return featuredImage;
  }

  public int getMedioProvider() {
    return medioProvider;
  }

  public int getHasOnlineDelivery() {
    return hasOnlineDelivery;
  }

  public int getIsDeliveringNow() {
    return isDeliveringNow;
  }

  public boolean isIncludeBogoOffers() {
    return includeBogoOffers;
  }

  public String getDeeplink() {
    return deeplink;
  }

  public String getOrderUrl() {
    return orderUrl;
  }

  public String getOrderDeeplink() {
    return orderDeeplink;
  }

  public int getIsTableReservationSupported() {
    return isTableReservationSupported;
  }

  public int getHasTableBooking() {
    return hasTableBooking;
  }

  public String getBookUrl() {
    return bookUrl;
  }

  public String getEventsUrl() {
    return eventsUrl;
  }

  public List<Object> getEstablishmentTypes() {
    return establishmentTypes;
  }
}
