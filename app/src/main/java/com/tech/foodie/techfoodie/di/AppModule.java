package com.tech.foodie.techfoodie.di;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.tech.foodie.techfoodie.BuildConfig;
import com.tech.foodie.techfoodie.remote.service.ApiManager;
import com.tech.foodie.techfoodie.remote.service.DataManager;
import com.tech.foodie.techfoodie.remote.service.RemoteService;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module public class AppModule {

  @Provides @Singleton HttpLoggingInterceptor provideHttpLoggingInterceptot() {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

    if (BuildConfig.DEBUG) {
      interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    } else {
      interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
    }

    return interceptor;
  }

  @Provides @Singleton OkHttpClient provideOkhttpClient(HttpLoggingInterceptor interceptor) {
    return
        new OkHttpClient.Builder().connectTimeout(60000, TimeUnit.MILLISECONDS)
            .readTimeout(60000, TimeUnit.MILLISECONDS)
            .writeTimeout(60000, TimeUnit.MILLISECONDS)
            .addNetworkInterceptor(interceptor).build();
  }

  @Provides @Singleton Retrofit.Builder provideRetrofitBuilder(OkHttpClient okHttpClient) {
    return new Retrofit.Builder().client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(new Gson()));
  }

  @Provides @Singleton Retrofit provideRetrofit(Retrofit.Builder builder) {

    return  builder.baseUrl("https://developers.zomato.com/api/v2.1/").build();
  }

  @Provides @Singleton RemoteService provideRemoteService(Retrofit retrofit) {
    return retrofit.create(RemoteService.class);
  }

  @Provides @Singleton DataManager provideDataManager(ApiManager apiManager) {
    return new DataManager(apiManager);
  }

  @Provides @Singleton ApiManager provideApiManager(RemoteService remoteService) {
    return new ApiManager(remoteService);
  }
}
