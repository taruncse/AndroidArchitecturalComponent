package comp.arc.tkb.com.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsersViewModel usersViewModel =
                ViewModelProviders.of(this).get(UsersViewModel.class);

        usersViewModel.getUserList()
                .observe(this, this::showUsers);
    }
}
