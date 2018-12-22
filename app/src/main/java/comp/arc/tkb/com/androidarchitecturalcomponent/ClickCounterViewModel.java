package comp.arc.tkb.com.androidarchitecturalcomponent;

import androidx.lifecycle.ViewModel;

public class ClickCounterViewModel extends ViewModel {
    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}