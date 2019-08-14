package com.example.mythirdapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TestRecyclerAdapter extends RecyclerView.Adapter<TestRecyclerAdapter.RecyclerViewHolder> {

    List<String> list;
    Context ctx;

    public TestRecyclerAdapter(List<String> list, Context ctx){
        this.list = list;
        this.ctx = ctx;

    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.test_recycler_item,viewGroup,false);
        RecyclerViewHolder holder = new RecyclerViewHolder(v,ctx,list);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
        String st = list.get(i);
        recyclerViewHolder.txtName.setText(st);


        }




    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txtName;
        List<String> li = new ArrayList<>();
        Context ctx;


        public RecyclerViewHolder(@NonNull View itemView,Context ctx,List<String> list) {
            super(itemView);
            this.li = list;
            this.ctx = ctx;
            itemView.setOnClickListener(this);
            txtName = itemView.findViewById(R.id.txtName);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            switch (position){
                case 0:
                    Intent intent1 = new Intent(this.ctx,DialActivity.class);
                    this.ctx.startActivity(intent1);
                    break;
                case 1:
                    Intent intent2 = new Intent(this.ctx,ProfileActivity.class);
                    this.ctx.startActivity(intent2);
                    break;
                case 2:
                    Intent intent3 = new Intent(this.ctx, MonthsActivity.class);
                    this.ctx.startActivity(intent3);
                    break;

            }

        }
    }
}
