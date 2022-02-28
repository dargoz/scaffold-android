package com.dargoz.scaffold.arch.features.feedback.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dargoz.scaffold.arch.R;
import com.dargoz.scaffold.arch.databinding.FeedbackHistoryItemBinding;
import com.dargoz.scaffold.arch.features.feedback.presentation.models.FeedbackItemVM;

import java.util.ArrayList;
import java.util.List;

public class FeedbackHistoryRVAdapter extends RecyclerView.Adapter<FeedbackHistoryRVAdapter.FeedbackHistoryVH> {

    private List<FeedbackItemVM> feedbackItemVMList = new ArrayList<>();

    public void setFeedbackItemVMList(List<FeedbackItemVM> feedbackItemVMList) {
        this.feedbackItemVMList = feedbackItemVMList;
    }

    @NonNull
    @Override
    public FeedbackHistoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feedback_history_item, parent, false);
        return new FeedbackHistoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedbackHistoryVH holder, int position) {
            holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return feedbackItemVMList.size();
    }

    class FeedbackHistoryVH extends RecyclerView.ViewHolder {
        FeedbackHistoryItemBinding binding;


        public FeedbackHistoryVH(@NonNull View itemView) {
            super(itemView);
            binding = FeedbackHistoryItemBinding.bind(itemView);
        }

        public void bind(int position) {
            if (binding != null) {
                binding.feedbackHistoryDateValueTv
                        .setText(feedbackItemVMList.get(position).getCreatedDate());
                binding.feedbackHistoryTitleValueTv
                        .setText(feedbackItemVMList.get(position).getTitle());
                binding.feedbackHistoryDescValueTv
                        .setText(feedbackItemVMList.get(position).getDescription());
            }
        }
    }

}
