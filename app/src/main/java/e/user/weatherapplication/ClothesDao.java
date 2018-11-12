package e.user.weatherapplication;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ClothesDao {

    @Query("SELECT * FROM clothes")
    List<Clothes> getAll();

    @Query("SELECT * FROM clothes WHERE id = :id")
    Clothes getById(long id);

    @Insert
    long insertClothes(Clothes clothes);
}
