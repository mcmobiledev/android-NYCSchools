package com.example.a20221121_michaelcasalinuovo_nycschools.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20221121_michaelcasalinuovo_nycschools.R;
import com.example.a20221121_michaelcasalinuovo_nycschools.model.SchoolNycModel;

import java.util.List;

public class SchoolsItemAdapter extends RecyclerView.Adapter<SchoolsItemAdapter.ViewHolder> {

    private List<SchoolNycModel> schoolNycModelList;
    private ItemClickListener itemClickListener;

    public SchoolsItemAdapter(List<SchoolNycModel> schoolNycModelList, ItemClickListener itemClickListener) {
        this.schoolNycModelList = schoolNycModelList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schools_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SchoolNycModel schoolNycModel = schoolNycModelList.get(position);
        holder.tvSchoolName.setText(schoolNycModel.getSchool_name());
        holder.tvDbnName.setText(schoolNycModel.getDbn());
        holder.tvLocation.setText(schoolNycModel.getLocation());
        holder.tvCity.setText(schoolNycModel.getCity());
    }

    @Override
    public int getItemCount() {
        return schoolNycModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvSchoolName;
        TextView tvDbnName;
        TextView tvLocation;
        TextView tvCity;

        ViewHolder(View itemView) {
            super(itemView);
            tvSchoolName = itemView.findViewById(R.id.tv_school_name);
            tvDbnName = itemView.findViewById(R.id.tv_dbn_name);
            tvLocation = itemView.findViewById(R.id.tv_location);
            tvCity = itemView.findViewById(R.id.tv_city);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onItemClick(schoolNycModelList.get(getAdapterPosition()));
        }
    }

    public interface ItemClickListener{
        void onItemClick(SchoolNycModel schoolNycModel);
    }
}
