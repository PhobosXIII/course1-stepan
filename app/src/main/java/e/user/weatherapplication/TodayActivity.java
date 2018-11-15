package e.user.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TodayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);
        FloatingActionButton fabList = findViewById(R.id.fabList);
        fabList.setOnClickListener(v -> startActivity(ListActivity.getStartIntent(this)));
    }


}
