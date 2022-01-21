package com.example.project16.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project16.R;
import com.example.project16.model.Member;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public final Context context;
    private final ArrayList<Member> itemList;


    public CustomAdapter(Context context, ArrayList<Member> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = itemList.get(position);

        if (holder instanceof CustomViewHolder) {
            TextView txt_name = holder.itemView.findViewById(R.id.text_view_title);
            ImageView imageView = holder.itemView.findViewById(R.id.item_image_view);

            txt_name.setText(member.getName());
            if (position % 3 == 0) {
                imageView.setImageResource(R.drawable.ic_image_1);
            } else if (position % 4 == 0) {
                imageView.setImageResource(R.drawable.ic_image_2);
            } else {
                imageView.setImageResource(R.drawable.ic_image_3);
            }
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    private static final class CustomViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public TextView txt_name;
        public ImageView imageView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            imageView = view.findViewById(R.id.item_image_view);
            txt_name = view.findViewById(R.id.text_view_title);
        }
    }
}
