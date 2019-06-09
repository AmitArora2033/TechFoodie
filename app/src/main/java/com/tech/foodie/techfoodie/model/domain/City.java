package com.tech.foodie.techfoodie.model.domain;

import android.os.Parcelable;
import com.google.auto.value.AutoValue;

@AutoValue public abstract class City  implements Parcelable {

  public static City create(int cityId, String cityName) {
    return new AutoValue_City(cityId, cityName);
  }

  public abstract int cityId();

  public abstract String cityName();
}
