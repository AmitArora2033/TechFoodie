package com.tech.foodie.techfoodie.di;

import android.app.Application;
import com.tech.foodie.techfoodie.App;
import com.tech.foodie.techfoodie.view.home.AppActivity;
import com.tech.foodie.techfoodie.view.home.search.HomeFragment;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = AppModule.class) public interface AppComponent {

  void inject(App app);

  void inject(AppActivity appActivity);

  void inject(HomeFragment homeFragment);

  @Component.Builder interface Builder {

    @BindsInstance Builder application(Application application);

    AppComponent build();
  }
}
