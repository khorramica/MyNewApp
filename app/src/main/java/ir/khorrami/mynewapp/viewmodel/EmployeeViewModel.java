package ir.khorrami.mynewapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ir.khorrami.mynewapp.api.ApiClient;
import ir.khorrami.mynewapp.api.ApiClientRxJava;
import ir.khorrami.mynewapp.model.Employee;

public class EmployeeViewModel extends ViewModel {

    CompositeDisposable compositeDisposable = new CompositeDisposable();
    //ApiClientRxJava apiClientRxJava;

    private MutableLiveData<List<Employee>> listMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<Employee>> getListMutableLiveData()
    {
       // apiClientRxJava = new ApiClientRxJava();
        compositeDisposable.add(ApiClientRxJava.GetInstance().GetApi().GetEmployeesByRxJava()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Employee>>() {
                    @Override
                    public void onSuccess(@NonNull List<Employee> employees) {
                        listMutableLiveData.setValue(employees);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(" Error RxJava",e.getMessage() + "");
                    }
                }));

        return listMutableLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
