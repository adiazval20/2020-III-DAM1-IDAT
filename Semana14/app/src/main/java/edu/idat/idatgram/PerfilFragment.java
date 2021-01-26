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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

import edu.idat.idatgram.adapter.PostAdapter;
import edu.idat.idatgram.entity.Post;
import edu.idat.idatgram.viewmodel.HomeViewModel;

public class PerfilFragment extends Fragment {
    private HomeViewModel viewModel;
    private RecyclerView rcvPosts;
    private LinearLayout lytPerfil;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rcvPosts = view.findViewById(R.id.rcvPosts);
        lytPerfil = view.findViewById(R.id.lytPerfil);

        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator translationY = ObjectAnimator.ofFloat(lytPerfil, "translationY", 400f, 0f);
        translationY.setDuration(1500);

        ObjectAnimator fade = ObjectAnimator.ofFloat(lytPerfil, "alpha", 0f, 1f);
        fade.setDuration(1500);

        animatorSet.play(translationY);
        animatorSet.play(fade);
        animatorSet.start();

        // Lista de posts
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        rcvPosts.setLayoutManager(new GridLayoutManager(getContext(), 3));
        PostAdapter adapter = new PostAdapter(R.layout.item_post_resume);
        rcvPosts.setAdapter(adapter);

        viewModel.list().observe((LifecycleOwner) getContext(), new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                adapter.loadData(posts);
            }
        });


    }
}