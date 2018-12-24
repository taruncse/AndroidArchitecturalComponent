package comp.arc.tkb.com.livedata;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UsersViewModel extends ViewModel {
    private MutableLiveData<List<User>> userLiveData =
            new MutableLiveData<>();
   // public UsersViewModel() {
       /* setUserListRefreshCallback(newUserList -> {
            userLiveData.postValue(newUserList);
        });*/
   // }

    public LiveData<List<User>> getUserList() {
        return userLiveData;
    }
}