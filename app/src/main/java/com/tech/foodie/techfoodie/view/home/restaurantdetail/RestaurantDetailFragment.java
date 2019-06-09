package com.tech.foodie.techfoodie.view.home.restaurantdetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tech.foodie.techfoodie.R;
import com.tech.foodie.techfoodie.base.BaseFragment;
import com.tech.foodie.techfoodie.model.domain.Restaurant;

public class RestaurantDetailFragment extends BaseFragment {

  private static final String BUNDLE_RESTAURANT = "bundle_restaurant";
  @BindView(R.id.img_restaurant) ImageView imageView;
  @BindView(R.id.rating) RatingBar ratingBar;
  @BindView(R.id.tv_cusines) TextView tvCusines;
  @BindView(R.id.tv_city) TextView tvCity;
  @BindView(R.id.open_zomato) TextView tvOpenZomato;
  @BindView(R.id.tv_address) TextView tvAddress;
  @BindView(R.id.tv_restaurant_name) TextView tvRestaurantName;
  @BindView(R.id.toolbar) Toolbar toolbar;
  private Restaurant restaurant;

  public static RestaurantDetailFragment newInstance(Restaurant restaurant) {

    Bundle args = new Bundle();
    args.putParcelable(BUNDLE_RESTAURANT, restaurant);
    RestaurantDetailFragment fragment = new RestaurantDetailFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override protected void detachView() {

  }

  @Override public int getContentLayout() {
    return R.layout.fragment_restaurant_detail;
  }

  @Override protected void initDependencies() {

  }

  @Override protected void onReady(Bundle savedInstanceState) {
    toolbar.setNavigationOnClickListener(v -> {
      getActivity().onBackPressed();
    });
    restaurant = (Restaurant) getArguments().getParcelable(BUNDLE_RESTAURANT);
    Glide.with(getContext())
        .load(restaurant.imageUrl())
        .error(R.drawable.notfound_banner)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(imageView);

    tvOpenZomato.setOnClickListener(v -> {
      Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(restaurant.deepLink()));
      startActivity(intent);
    });

    tvAddress.setText(restaurant.location().address());
    tvCity.setText(restaurant.location().city());
    ratingBar.setRating(Float.parseFloat(restaurant.uSerRating().aggregateRating()));
    tvCusines.setText(restaurant.cusines());
    tvRestaurantName.setText(restaurant.restaurantName());
  }
}
