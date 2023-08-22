package com.example.suggestions;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String jsonData ="[\n" +
            "  { \"timestamp\": \"2023-08-11T08:00:00Z\", \"health_score\": 20 },\n" +
            "  { \"timestamp\": \"2023-08-11T09:00:00Z\", \"health_score\": 20 },\n" +
            "  { \"timestamp\": \"2023-08-11T10:00:00Z\", \"health_score\": 20 },\n" +
            "  { \"timestamp\": \"2023-08-11T11:00:00Z\", \"health_score\": 20 },\n" +
            "  { \"timestamp\": \"2023-08-11T12:00:00Z\", \"health_score\": 20 },\n" +
            "  { \"timestamp\": \"2023-08-11T13:00:00Z\", \"health_score\": 20 },\n" +
            "  { \"timestamp\": \"2023-08-11T14:00:00Z\", \"health_score\": 20 },\n" +
            "  { \"timestamp\": \"2023-08-11T15:00:00Z\", \"health_score\": 20 },\n" +
            "  { \"timestamp\": \"2023-08-11T16:00:00Z\", \"health_score\": 20 },\n" +
            "  { \"timestamp\": \"2023-08-11T17:00:00Z\", \"health_score\": 20 }\n" +
            "]\n";
    private RecyclerView recyclerView;
    private CardAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Initialize and set up the adapter and layout manager
        cardAdapter = new CardAdapter(new JSONArray(), this);
        recyclerView.setAdapter(cardAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        displayList(jsonData);
    }

    private void displayList(String response) {
        try {
            JSONArray jsonArray = new JSONArray(response);
            cardAdapter.setCardData(jsonArray);
            cardAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}



