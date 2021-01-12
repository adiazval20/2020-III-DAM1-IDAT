package edu.idat.idatgram.repository;

import java.util.ArrayList;
import java.util.List;

import edu.idat.idatgram.entity.Post;

public class PostRepository {
    private static PostRepository instance;
    private List<Post> posts;

    private PostRepository() {
        posts = new ArrayList<>();
    }

    public static PostRepository getInstance() {
        if (instance == null) {
            instance = new PostRepository();
        }
        return instance;
    }

    public List<Post> list() {
        return posts;
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(posts.size() + 1);
            this.posts.add(post);
        } else {
            posts.stream().forEach(p -> {
                if (p.getId() == post.getId()) {
                    p = post;
                }
            });
        }
    }
}
