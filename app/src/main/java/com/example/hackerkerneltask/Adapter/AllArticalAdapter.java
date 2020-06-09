package com.example.hackerkerneltask.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackerkerneltask.R;
import com.example.hackerkerneltask.model.AllArtical;

import java.util.List;

public class AllArticalAdapter extends RecyclerView.Adapter<AllArticalAdapter.ArticalViewHolder> {

    private Context context;
    private List<AllArtical> list;

    public AllArticalAdapter(Context context, List<AllArtical> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ArticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.allartical_item,parent,false);
        return new ArticalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticalViewHolder holder, int position) {

        holder.title.setText(list.get(position).getTitle());
        holder.description.setText(list.get(position).getDiscription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ArticalViewHolder extends RecyclerView.ViewHolder {

        TextView title,description;

        public ArticalViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);

        }
    }
}

