package com.example.peter.workcomplain.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.peter.workcomplain.R;
import com.example.peter.workcomplain.retrofit.model.NotificationResponse;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.RecyclerViewHolder> {

    private List<NotificationResponse> notice;
    Context context;

    public NotificationAdapter(List<NotificationResponse> notice, Context context) {
        this.notice = notice;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notification_list, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        NotificationResponse notification = notice.get(position);
        holder.tvNotifTitle.setText(notification.getTitle());
        holder.tvNotifBody.setText(notification.getBody());
        holder.tvNotifDate.setText(notification.getDate());

    }

    @Override
    public int getItemCount() {
        return notice.size();
    }


    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNotifTitle;
        private TextView tvNotifDate;
        private TextView tvNotifBody;

        RecyclerViewHolder(View view) {
            super(view);
            tvNotifTitle = view.findViewById(R.id.notifTitle);
            tvNotifDate = view.findViewById(R.id.notif_date);
            tvNotifBody = view.findViewById(R.id.notif_body);
        }
    }
}