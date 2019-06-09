package com.tech.foodie.techfoodie.view.home.search;

import com.tech.foodie.techfoodie.base.BaseView;
import com.tech.foodie.techfoodie.model.domain.City;
import com.tech.foodie.techfoodie.model.domain.Location;
import com.tech.foodie.techfoodie.model.domain.Restaurant;
import java.util.List;

public interface HomeView extends BaseView {

  void showRestaurantList(List<Restaurant> restaurants);

  void showLocation(List<Location> locations);

  void showCities(List<City> cities);
}
