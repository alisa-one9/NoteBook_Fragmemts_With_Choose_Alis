package com.example.notebook_fragmemts_with_choose_alis.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.notebook_fragmemts_with_choose_alis.App;
import com.example.notebook_fragmemts_with_choose_alis.databinding.FragmentDashboardBinding;
import com.example.notebook_fragmemts_with_choose_alis.models.TextModel;
import com.example.notebook_fragmemts_with_choose_alis.room.AppDataBase;
import com.example.notebook_fragmemts_with_choose_alis.room.NoteDao;

import java.util.List;

public class DashboardFragment extends Fragment {
    private FragmentDashboardBinding binding;
    private AppDataBase appDataBase;
    private NoteDao noteDao;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView =binding.rvNoteBook;
        recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
        recyclerView.setHasFixedSize(true);
        NoteBookAdapter adapter =new NoteBookAdapter();
        recyclerView.setAdapter(adapter);
        appDataBase = Room.databaseBuilder(binding.getRoot().getContext()
                ,AppDataBase.class,"database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
        noteDao = appDataBase.noteDao();
        adapter.setList(noteDao.getAll());
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }






}