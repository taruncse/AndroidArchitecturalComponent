package comp.arc.tkb.com.livedata;

import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private String TAG = MainActivityViewModel.class.getSimpleName();
    Handler handler = new Handler(); // new handler
    private MutableLiveData<List<String>> fruitList;
    int i = 0;
    LiveData<List<String>> getFruitList() {
        if (fruitList == null) {
            fruitList = new MutableLiveData<>();
            loadFruits();
            callAgain();
        }
        return fruitList;


    }

    private void callAgain(){

        handler.postDelayed(runnable, 1000*20); // 10 mins int.
    }

    private Runnable runnable = () -> {

        loadFruits();

    };

    private void loadFruits() {
        // do async operation to fetch users
        Handler myHandler = new Handler();
        myHandler.postDelayed(() -> {
            List<String> fruitsStringList = new ArrayList<>();
            fruitsStringList.add("Mango"+i);
            fruitsStringList.add("Apple"+i);
            fruitsStringList.add("Orange"+i);
            fruitsStringList.add("Banana"+i);
            fruitsStringList.add("Grapes"+i);
            long seed = System.nanoTime();
            Collections.shuffle(fruitsStringList, new Random(seed));

            fruitList.setValue(fruitsStringList);
            i++;
        }, 2000);





    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "on cleared called");
    }

}