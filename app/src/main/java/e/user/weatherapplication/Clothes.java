package e.user.weatherapplication;

import java.util.Objects;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "clothes")
public class Clothes {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String clothesName;
    private int tFrom;
    private int tTo;
    private String description;


    public Clothes(String clothesName, int tFrom, int tTo, String description) {
        this(0, clothesName, tFrom, tTo, description);
    }

    @Ignore
    public Clothes(long id, String clothesName, int tFrom, int tTo, String description) {
        this.id = id;
        this.clothesName = clothesName;
        this.tFrom = tFrom;
        this.tTo = tTo;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClothesName() {
        return clothesName;
    }

    public void setClothesName(String clothesName) {
        this.clothesName = clothesName;
    }

    public int getTFrom() {
        return tFrom;
    }

    public void setTFrom(int tFrom) {
        this.tFrom = tFrom;
    }

    public int getTTo() {
        return tTo;
    }

    public void setTTo(int tTo) {
        this.tTo = tTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothes clothes = (Clothes) o;
        return id == clothes.id &&
                tFrom == clothes.tFrom &&
                tTo == clothes.tTo &&
                Objects.equals(clothesName, clothes.clothesName) &&
                Objects.equals(description, clothes.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, clothesName, tFrom, tTo, description);
    }
}
