package edu.idat.idatgram;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class PerfilFragment extends Fragment {

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
        LinearLayout lytPerfil = view.findViewById(R.id.lytPerfil);

        AnimatorSet animatorSet = new AnimatorSet();

        ObjectAnimator translationY = ObjectAnimator.ofFloat(lytPerfil, "translationY", 400f, 0f);
        translationY.setDuration(1500);
//        translationY.start();

        ObjectAnimator fade = ObjectAnimator.ofFloat(lytPerfil, "alpha", 0f, 1f);
        fade.setDuration(1500);

        animatorSet.play(translationY);
        animatorSet.play(fade);
        animatorSet.start();
    }
}