package com.example.notebook_fragmemts_with_choose_alis.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.room.Room;

import com.example.notebook_fragmemts_with_choose_alis.R;
import com.example.notebook_fragmemts_with_choose_alis.databinding.FragmentHomeBinding;
import com.example.notebook_fragmemts_with_choose_alis.models.TextModel;
import com.example.notebook_fragmemts_with_choose_alis.room.AppDataBase;
import com.example.notebook_fragmemts_with_choose_alis.room.NoteDao;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private List<TextModel> list = new ArrayList<>();
    private AppDataBase appDataBase;
    private NoteDao noteDao;

    int number =1;
    private NavController navController;
    private static final String KEY_FRAGMENT = "KEY_FRAGMENT";
    private static final String KEY_MODEL = "KEY_MODEL";



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        this.appDataBase = Room.databaseBuilder(
                        binding.getRoot().getContext(),
                        AppDataBase.class, "database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        noteDao = appDataBase.noteDao();

        binding.btnWrite.setOnClickListener(v -> {

            TextModel textModel = new TextModel();
            textModel.setTextC(number++  +".  "+ binding.comeText.getText().toString());

            if(!(textModel.getTextC().isEmpty())){
                noteDao.insert(textModel);
                navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
                navController.navigate(R.id.action_navigation_home_to_navigation_dashboard);
            }else{
                Toast.makeText(requireActivity(), "Emty", Toast.LENGTH_SHORT).show();
            }
         });

        return root;
    }

}