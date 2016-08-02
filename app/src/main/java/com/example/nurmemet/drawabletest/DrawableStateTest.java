package com.example.nurmemet.drawabletest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by nurmemet on 8/2/2016.
 */
public class DrawableStateTest extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawable_state_test);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(DrawableStateTest.this).inflate(R.layout.item_list, parent, false);
                RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(view) {
                };
                return holder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                TextView name = (TextView) holder.itemView.findViewById(R.id.name);
                name.setText("nurmemet");
                MessageListItem item = (MessageListItem) holder.itemView;
                if (position == 0 || position == 3) {

                    item.setMessageReaded(true);
                } else {
                    item.setMessageReaded(false);
                }

            }

            @Override
            public int getItemCount() {
                return 5;
            }
        });

    }
}
