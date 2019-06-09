package com.tech.foodie.techfoodie.view.home;

import com.tech.foodie.techfoodie.base.BaseView;
import com.tech.foodie.techfoodie.model.domain.City;
import java.util.List;

interface AppView extends BaseView {
  void showCities(List<City> cities);
}
