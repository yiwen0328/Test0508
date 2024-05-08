package com.example.test0508;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

class StuDataAapter extends RecyclerView.Adapter<StuDataAapter.ViewHolder>{

    private TextView tvName1;
    private TextView tvHeight1;
    private List<StuData> stuDataList;

    public StuDataAapter(List<StuData> stuDataList) {
        this.stuDataList = stuDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = View.inflate(context, R.layout.activity_my_data_view, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StuData stuData = stuDataList.get(position);
        tvHeight1.setText(stuData.getHeight());
        tvName1.setText(stuData.getName());

    }

    @Override
    public int getItemCount() {
        return stuDataList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             tvName1 = itemView.findViewById(R.id.tvname);
             tvHeight1 = itemView.findViewById(R.id.tvheight);
        }
    }
}