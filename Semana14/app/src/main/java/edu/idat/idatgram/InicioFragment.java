package edu.idat.idatgram;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import edu.idat.idatgram.adapter.PostAdapter;
import edu.idat.idatgram.entity.Post;
import edu.idat.idatgram.repository.PostRepository;
import edu.idat.idatgram.viewmodel.HomeViewModel;

public class InicioFragment extends Fragment {
    private HomeViewModel viewModel;

    public InicioFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView rcvPosts = view.findViewById(R.id.rcvPosts);
        rcvPosts.setLayoutManager(new LinearLayoutManager(getContext()));

        PostAdapter adapter = new PostAdapter();
        rcvPosts.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        viewModel.list().observe((LifecycleOwner) getContext(), new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                adapter.loadData(posts);
            }
        });
    }
}