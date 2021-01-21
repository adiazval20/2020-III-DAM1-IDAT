package edu.idat.idatgram.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.idat.idatgram.R;
import edu.idat.idatgram.entity.Post;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
    private int layout;
    private List<Post> posts;

    public PostAdapter() {
        this.layout = R.layout.item_post;
        this.posts = new ArrayList<>();
    }

    public PostAdapter(int layout) {
        this.layout = layout;
        this.posts = new ArrayList<>();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new PostViewHolder(view, layout);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.loadData(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void loadData(List<Post> posts) {
        this.posts.clear();
        this.posts.addAll(posts);
        this.notifyDataSetChanged();
    }
}
