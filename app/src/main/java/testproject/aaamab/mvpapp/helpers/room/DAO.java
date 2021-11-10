package testproject.aaamab.mvpapp.helpers.room;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DAO {

    @Query("SELECT * from users")
    List<Users> getAllUsers();

    @Query("SELECT * from users WHERE id IN (:ids)")
    List<Users> getUsersByIds(int[] ids);

    @Query("SELECT * from users WHERE name LIKE :username")
    Users getUserByName(String username);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Users users);

    @Delete
    void delete(Users user);


}
