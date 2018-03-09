package com.example.details.model.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.details.R;
import com.example.details.model.entity.Home_entity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by 家 on 2018/3/1.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    Context context;
    Home_entity list;

    public HomeAdapter(Context context, Home_entity list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.home_rcv_item,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String img=new String(list.getTuijian().getList().get(position).getImages());
        String[] split = img.split("\\|");
        DraweeController controller=Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(split[0]))
                .build();
        holder.homeimage.setController(controller);
        holder.hometitls.setText(list.getTuijian().getList().get(position).getTitle());
    }
    @Override
    public int getItemCount() {
        return list==null?0:list.getTuijian().getList().size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView hometitls;
//        private final TextView homeprice;
        private final SimpleDraweeView homeimage;
        public ViewHolder(View itemView) {
            super(itemView);
            homeimage = itemView.findViewById(R.id.home_image);
//            homeprice = itemView.findViewById(R.id.home_price);
            hometitls = itemView.findViewById(R.id.home_titls);
        }
    }




}
