package e.user.weatherapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    public static Intent getStartIntent(Context context) {
        return new Intent(context, AddActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actionAdd) {
            TextInputLayout clothesName = findViewById(R.id.itlClothesName);
            TextInputLayout temperatureFrom = findViewById(R.id.itlTemperatureFrom);
            TextInputLayout temperatureTo = findViewById(R.id.itlTemperatureTo);
            EditText description = findViewById(R.id.itDescription);

            int tFrom = Integer.valueOf(temperatureFrom.getEditText().getText().toString());
            int tTo = Integer.valueOf(temperatureTo.getEditText().getText().toString());

            Clothes clothes = new Clothes(clothesName.getEditText().getText().toString(),
                    tFrom, tTo, description.getText().toString());

            AppDatabase.getInstance(this).clothesDao().insertClothes(clothes);

            finish();

            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
