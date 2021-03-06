package edu.idat.idatgram.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.idat.idatgram.entity.Post;

@Dao
public interface PostDao {
    @Query("SELECT * FROM Post")
    LiveData<List<Post>> list();

    @Insert
    long insert(Post post);

    @Update
    void update(Post post);

    @Delete
    void delete(Post post);
}
