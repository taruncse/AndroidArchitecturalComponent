package comp.arc.tkb.com.androidarchitecturalcomponent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    protected TextView clickCountText;
    protected Button increment_button;
    private ClickCounterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickCountText = findViewById(R.id.click_count_text);

        viewModel = ViewModelProviders.of(this).get(ClickCounterViewModel.class);
        displayClickCount(viewModel.getCount());
    }

    public void incrementClickCount(View button) {
        viewModel.setCount(viewModel.getCount() + 1);
        displayClickCount(viewModel.getCount());
    }

    private void displayClickCount(int clickCount) {
        clickCountText.setText(String.valueOf(clickCount));
    }
}