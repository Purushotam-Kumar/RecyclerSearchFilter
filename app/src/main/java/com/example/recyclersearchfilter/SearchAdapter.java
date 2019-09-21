package com.example.recyclersearchfilter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> implements Filterable {
    private List<SearchModel> searchModelList;
    private List<SearchModel> searchModelListFull;

    SearchAdapter(List<SearchModel> searchModelList) {
        this.searchModelList = searchModelList;
        searchModelListFull = new ArrayList<>(searchModelList);
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        SearchModel currentItem = searchModelList.get(position);

        holder.ivUserImage.setImageResource(currentItem.getUserImage());
        holder.tvUserName.setText(currentItem.getUserName());
        holder.tvUserChat.setText(currentItem.getUserChat());
    }

    @Override
    public int getItemCount() {
        return searchModelList.size();
    }

    @Override
    public Filter getFilter() {
        return searchFilter;
    }

    private Filter searchFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<SearchModel> filteredList = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(searchModelListFull);
            } else {
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for (SearchModel item : searchModelListFull) {
                    if (item.getUserName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            searchModelList.clear();
            searchModelList.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };

    class SearchViewHolder extends RecyclerView.ViewHolder {
        ImageView ivUserImage;
        TextView tvUserName;
        TextView tvUserChat;

        SearchViewHolder(View itemView) {
            super(itemView);
            ivUserImage = itemView.findViewById(R.id.iv_userImage);
            tvUserName = itemView.findViewById(R.id.tv_userName);
            tvUserChat = itemView.findViewById(R.id.tv_userChat);
        }
    }

}