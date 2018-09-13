package com.example.peter.workcomplain.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.peter.workcomplain.R;
import com.example.peter.workcomplain.retrofit.model.ComplainResponseModel;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private List<ComplainResponseModel> complains;
    Context context;

    public RecyclerAdapter(List<ComplainResponseModel> complains, Context context) {
        this.complains = complains;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.complain_list, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        ComplainResponseModel complain = complains.get(position);
        holder.tvComplainTitle.setText(complain.getComplainTitle());
        holder.tvComplainBody.setText(complain.getComplainBody());
        holder.tvComplainStatus.setText(complain.getStatus());
        holder.tvComplainDate.setText(complain.getDate());

    }

    @Override
    public int getItemCount() {
        return complains.size();
    }


    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView tvComplainTitle;
        private TextView tvComplainDate;
        private TextView tvComplainStatus;
        private TextView tvComplainBody;

        RecyclerViewHolder(View view) {
            super(view);
            tvComplainTitle = view.findViewById(R.id.tvComplaintitle);
            tvComplainDate = view.findViewById(R.id.tvDate);
            tvComplainStatus = view.findViewById(R.id.tvStatus);
            tvComplainBody = view.findViewById(R.id.tvBody);
        }
    }
}