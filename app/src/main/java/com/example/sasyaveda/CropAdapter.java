package com.example.sasyaveda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;

public class CropAdapter extends RecyclerView.Adapter<CropAdapter.Innerclass> {

    Context ctx;
    List<CropModel> cdata;
    public CropAdapter(FragmentActivity news, List<CropModel> cm){
        ctx=news;
        cdata=cm;
    }

    @NonNull
    @Override
    public Innerclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(ctx).inflate(R.layout.design,parent,false);

        return new Innerclass(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Innerclass holder, int position) {


        holder.ad.setText(cdata.get(position).getArrival_date());
        holder.com.setText(cdata.get(position).getCommodity());
        holder.dist.setText(cdata.get(position).getDistrict());
        holder.mark.setText(cdata.get(position).getMarket());
        holder.max.setText(cdata.get(position).getMax_price());
        holder.min.setText(cdata.get(position).getMin_price());
        holder.mod.setText(cdata.get(position).getModal_price());
        holder.state.setText(cdata.get(position).getState());
        holder.var.setText(cdata.get(position).getVariety());
        holder.time.setText(cdata.get(position).getTimestamp());


    }

    @Override
    public int getItemCount() {
        return cdata.size();
    }


    public class Innerclass extends RecyclerView.ViewHolder {

        TextView ad,com,dist,mark,state,var,max,min,mod,time;
        public Innerclass(@NonNull View itemView) {
            super(itemView);
            ad=itemView.findViewById(R.id.adate);
            com=itemView.findViewById(R.id.comm);
            dist=itemView.findViewById(R.id.dist);
            mark=itemView.findViewById(R.id.market);
            state=itemView.findViewById(R.id.state);
            var=itemView.findViewById(R.id.variety);
            max=itemView.findViewById(R.id.maxprice);
            min=itemView.findViewById(R.id.minprice);
            mod=itemView.findViewById(R.id.modal);
            time=itemView.findViewById(R.id.time);
        }
    }
}
