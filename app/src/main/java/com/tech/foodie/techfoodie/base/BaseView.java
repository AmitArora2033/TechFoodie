package com.tech.foodie.techfoodie.base;

import com.tech.foodie.techfoodie.model.domain.Location;
import com.tech.foodie.techfoodie.model.domain.Restaurant;
import java.util.List;

public interface BaseView {

  void showToast(String message);

  void showToast(int resId);

  void showError(String errorMessage);

  void showContent();

  void showProgress();

}