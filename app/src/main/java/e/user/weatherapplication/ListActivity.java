package e.user.weatherapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

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

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private void initList() {
        RecyclerView rvPeople = findViewById(R.id.rvClothesList);
        rvPeople.setHasFixedSize(true);
        rvPeople.setLayoutManager(new LinearLayoutManager(this));
        rvPeople.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


        List<Clothes> people = new ArrayList<>(3);
        people.add(new Clothes("T-shirt", -5, 25, "ABC"));

        adapter = new ClothesAdapter(people, person -> {
            Intent intent = AddActivity.getStartIntent(this);
            startActivity(intent);
        });
        rvPeople.setAdapter(adapter);
    }
}
