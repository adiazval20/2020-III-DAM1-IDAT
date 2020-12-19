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
import android.widget.ImageView;

public class InicioFragment extends Fragment {
    public InicioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ImageView imgLogo = view.findViewById(R.id.imgLogo);

        AnimatorSet animatorSet = new AnimatorSet();

        ObjectAnimator rotation = ObjectAnimator.ofFloat(imgLogo, "rotation", 360f);
        rotation.setDuration(3000);

        ObjectAnimator fade = ObjectAnimator.ofFloat(imgLogo, "alpha", 0.3f, 1f);
        fade.setDuration(1000);

        animatorSet.playSequentially(fade, rotation);
        animatorSet.start();
    }
}