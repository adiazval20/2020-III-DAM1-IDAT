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
    private List<Post> posts;

    public PostAdapter() {
        this.posts = new ArrayList<>();
    }

    public PostAdapter(List<Post> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
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
