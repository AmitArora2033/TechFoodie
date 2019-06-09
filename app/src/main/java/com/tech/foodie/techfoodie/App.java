package com.tech.foodie.techfoodie;

import android.app.Application;
import android.content.Context;
import com.tech.foodie.techfoodie.di.AppComponent;
import com.tech.foodie.techfoodie.di.DaggerAppComponent;

public class App extends Application {

  private static AppComponent appComponent;

  public static AppComponent getAppComponent() {
    return appComponent;
  }

  public static App get(Context context) {
    return (App) context.getApplicationContext();
  }

  @Override public void onCreate() {
    super.onCreate();

    appComponent =
        DaggerAppComponent.builder().application(this).build();
    appComponent.inject(this);
  }
}
