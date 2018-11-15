package e.user.weatherapplication;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TodayActivity extends AppCompatActivity {

    DataGenerator generator = new DataGenerator();
    ClothesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);

        TextView tvDayTemp = findViewById(R.id.tvDayTemperature);
        TextView tvNightTemp = findViewById(R.id.tvNightTemperature);

        final int temperature = generator.getTemperature();
        tvDayTemp.setText(String.valueOf(temperature));
        tvNightTemp.setText(String.valueOf(generator.getTemperature()));
        initList(temperature);

        FloatingActionButton fabList = findViewById(R.id.fabList);
        fabList.setOnClickListener(v -> startActivity(ListActivity.getStartIntent(this)));
    }

    private void initList(int temperature) {
        RecyclerView rvClothes = findViewById(R.id.rvClothesList);
        rvClothes.setHasFixedSize(true);
        rvClothes.setLayoutManager(new LinearLayoutManager(this));
        rvClothes.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        List<Clothes> clothes = AppDatabase.getInstance(this).clothesDao().getByTemperature(temperature);
        adapter = new ClothesAdapter(clothes);
        rvClothes.setAdapter(adapter);
    }
}
