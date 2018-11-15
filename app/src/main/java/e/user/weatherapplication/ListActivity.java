package e.user.weatherapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListActivity extends AppCompatActivity {

    ClothesAdapter adapter;

    public static Intent getStartIntent(Context context){
        return new Intent(context, ListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initList();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> startActivity(AddActivity.getStartIntent(this)));
    }

    private void initList() {
        RecyclerView rvClothes = findViewById(R.id.rvClothesList);
        rvClothes.setHasFixedSize(true);
        rvClothes.setLayoutManager(new LinearLayoutManager(this));
        rvClothes.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        List<Clothes> clothes = new ArrayList<>(3);
        clothes.add(new Clothes("T-shirt", -5, 25, "ABC"));

        adapter = new ClothesAdapter(clothes);
        rvClothes.setAdapter(adapter);
    }
}
