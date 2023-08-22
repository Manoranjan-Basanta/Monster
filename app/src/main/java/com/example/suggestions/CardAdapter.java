package com.example.suggestions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

        private JSONArray card;

        public CardAdapter(JSONArray jsonArray, MainActivity mainActivity) {
            this.card = jsonArray;
        }

        @NonNull
        @Override
        public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
            return new CardViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
            try {
                JSONObject cardJSONObject = card.getJSONObject(position);
                holder.item_score.setText(cardJSONObject.getString("health_score"));
                holder.time_score.setText(cardJSONObject.getString("timestamp"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public int getItemCount() {
            return card.length(); // Use the length of the JSONArray
        }

    public void setCardData(JSONArray jsonArray) {
        this.card = jsonArray;
        notifyDataSetChanged();
    }
    class CardViewHolder extends RecyclerView.ViewHolder {
            TextView item_score, time_score;

            CardViewHolder(@NonNull View itemView) {
                super(itemView);
                item_score = itemView.findViewById(R.id.item_score);
                time_score = itemView.findViewById(R.id.time_score);
            }
        }
    }


