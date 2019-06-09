package com.tech.foodie.techfoodie.base;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import butterknife.ButterKnife;
import com.tech.foodie.techfoodie.R;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {
  private static final int REQUET_CODE_LOCATION_PERMISSION = 101;

  @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    if (requestCode == REQUET_CODE_LOCATION_PERMISSION
        && grantResults.length > 0
        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
      showToast(getString(R.string.permission_success));
      locationPermissionGranted();
    }

    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
  }

  protected abstract void locationPermissionGranted();

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initDependencies();
  }

  @Override public void setContentView(@LayoutRes int resId) {
    super.setContentView(resId);
    ButterKnife.bind(this);
    onReady();
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      finish();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    destroyPresenter();
  }

  @Override public void showToast(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }

  @Override public void showToast(int resId) {
    Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
  }

  public boolean checkHasLocationPermission() {

    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED) {

      return false;
    } else {
      return true;
    }
  }

  public void getLocationPermission() {
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
      requestPermissions(new String[] { Manifest.permission.ACCESS_FINE_LOCATION },
          REQUET_CODE_LOCATION_PERMISSION);
    }
  }

  public abstract void initDependencies();

  public abstract void destroyPresenter();

  public abstract void onReady();
}
