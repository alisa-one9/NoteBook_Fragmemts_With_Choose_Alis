package com.example.notebook_fragmemts_with_choose_alis.ui.dashboard;

import android.view.LayoutInflater;

import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;


import com.example.notebook_fragmemts_with_choose_alis.databinding.ItemListBinding;
import com.example.notebook_fragmemts_with_choose_alis.models.TextModel;
import com.example.notebook_fragmemts_with_choose_alis.room.AppDataBase;
import com.example.notebook_fragmemts_with_choose_alis.room.NoteDao;

import java.util.ArrayList;
import java.util.List;

public class NoteBookAdapter extends RecyclerView.Adapter<NoteBookAdapter.ViewHolder> {
   private List<TextModel> list = new ArrayList<>();
   private NoteDao noteDao;

   public void setList(List<TextModel>list){
       this.list =list;
       notifyDataSetChanged();
   }

    @NonNull
    @Override
    public NoteBookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListBinding itemListBinding =ItemListBinding
                .inflate(LayoutInflater.from(parent.getContext()),parent,false);
        ViewHolder viewHolder = new ViewHolder(itemListBinding);
        return viewHolder;    }

    @Override
    public void onBindViewHolder(@NonNull NoteBookAdapter.ViewHolder holder, int position) {
        noteDao = Room.databaseBuilder(
                holder.binding.getRoot().getContext(),
                AppDataBase.class,"database")
                .allowMainThreadQueries()
                .build()
                .noteDao();
        TextModel textModel = list.get(position);
        holder.binding.textCard.setText(textModel.getTextC());


    }
    @Override
    public int getItemCount() {
        return list.size();
    }


    public void addApdateList(List<TextModel> models) {
        list.clear();
        list = models;
        notifyDataSetChanged();
    }

    public void addItem(TextModel model) {
        list.add(list.size()-1, model);
        notifyItemChanged(list.indexOf(0));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       private ItemListBinding binding;


        public ViewHolder(@NonNull ItemListBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

    }
}
