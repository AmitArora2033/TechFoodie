package com.tech.foodie.techfoodie.view.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tech.foodie.techfoodie.R;
import com.tech.foodie.techfoodie.model.domain.Restaurant;
import java.util.ArrayList;
import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

  private final Context context;
  private final LayoutInflater inflater;
  private final RestaurantClickListener listener;
  private List<Restaurant> restaurants = new ArrayList<>();

  public RestaurantAdapter(Context context, RestaurantClickListener listener) {
    this.restaurants = restaurants;
    this.listener = listener;
    this.context = context;
    this.inflater = LayoutInflater.from(context);
  }

  public void setRestaurantData(
      ArrayList<Restaurant> restaurants) {
    this.restaurants = restaurants;
  }

  @NonNull @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new ViewHolder(inflater.inflate(R.layout.item_restaurant, parent, false), listener);
  }

  @Override public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.restaurantName.setText(restaurants.get(position).restaurantName());
    holder.tvDescription.setText(restaurants.get(position).cusines());
    Glide.with(holder.restaurantImage.getContext())
        .load(restaurants.get(position).imageUrl())
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .error(R.drawable.notfound_banner)
        .into(holder.restaurantImage);
    holder.ratingBar.setRating(
        Float.parseFloat(restaurants.get(position).uSerRating().aggregateRating()));
    holder.tvRestaurantCity.setText(restaurants.get(position).location().city());
    holder.tvPriceRange.setText(holder.tvPriceRange.getContext()
        .getString(R.string.prince_for_two, restaurants.get(position).currency(),
            String.valueOf(restaurants.get(position).avgCostForTwo())));
  }

  @Override public int getItemCount() {
    return restaurants.size();
  }

  public interface RestaurantClickListener {

    void onRestauratSelected(Restaurant restaurant);
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_restaurant_name) TextView restaurantName;
    @BindView(R.id.rating) RatingBar ratingBar;
    @BindView(R.id.tv_restautant_description) TextView tvDescription;
    @BindView(R.id.img_restaurant) ImageView restaurantImage;
    @BindView(R.id.delivery_time) TextView tvDeliveryTime;
    @BindView(R.id.restaurant_city) TextView tvRestaurantCity;
    @BindView(R.id.tv_price_per_person) TextView tvPriceRange;

    public ViewHolder(@NonNull View itemView, RestaurantClickListener listener) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      itemView.setOnClickListener(
          v -> listener.onRestauratSelected(restaurants.get(getAdapterPosition())));
    }
  }
}
