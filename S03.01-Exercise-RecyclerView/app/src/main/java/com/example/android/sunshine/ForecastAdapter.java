package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by abhishek on 19/2/18.
 */

public class ForecastAdapter extends
    RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {

  private String[] mWeatherData;

  public ForecastAdapter(String[] mWeatherData) {
    this.mWeatherData = mWeatherData;
  }

  void setWeatherData(String[] weatherData) {
    mWeatherData = weatherData;
    notifyDataSetChanged();
  }

  @Override
  public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    Context context = parent.getContext();

    View inflatedView =
        LayoutInflater
            .from(context)
            .inflate(R.layout.forecast_list_item, parent, false);

    return new ForecastAdapterViewHolder(inflatedView);
  }

  @Override
  public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
    holder.mWeatherTextView.setText(mWeatherData[position]);
  }

  @Override
  public int getItemCount() {
    if (mWeatherData == null) {
      return 0;
    }
    return mWeatherData.length;
  }

  class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {

    public final TextView mWeatherTextView;

    public ForecastAdapterViewHolder(View itemView) {
      super(itemView);
      mWeatherTextView = (TextView) itemView.findViewById(R.id.tv_weather_data);
    }
  }


}
