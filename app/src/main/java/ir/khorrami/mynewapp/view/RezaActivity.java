package ir.khorrami.mynewapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;

import java.util.List;

import ir.khorrami.mynewapp.R;
import ir.khorrami.mynewapp.adapter.EmployeAdapter;
import ir.khorrami.mynewapp.databinding.ActivityRezaBinding;
import ir.khorrami.mynewapp.model.Employee;
import ir.khorrami.mynewapp.viewmodel.EmployeeViewModel;

public class RezaActivity extends AppCompatActivity {


    RecyclerView rcvRezaList;
    EmployeAdapter adapter;

    ActivityRezaBinding binding;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_reza);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_reza);

        rcvRezaList = findViewById(R.id.rcv_RezaList);
//        rcvRezaList = binding.rcvRezaList;
        EmployeeViewModel employeeViewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);
        MutableLiveData<List<Employee>> listMutableLiveData = employeeViewModel.getListMutableLiveData();

        listMutableLiveData.observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employees) {
                rcvRezaList.setHasFixedSize(true);
                rcvRezaList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new EmployeAdapter(getApplicationContext(),employees);
                rcvRezaList.setAdapter(adapter);
            }
        });
    }
}