package comp.arc.tkb.com.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.list);
        ProgressBar progressBar =  findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);


        MainActivityViewModel model = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        model.getFruitList().observe(this, fruitlist -> {
            // update UI
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, fruitlist);
            // Assign adapter to ListView
            listView.setAdapter(adapter);
            progressBar.setVisibility(View.GONE);
        });
    }
}