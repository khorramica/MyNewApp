package ir.khorrami.mynewapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ir.khorrami.mynewapp.R;
import ir.khorrami.mynewapp.adapter.EmployeAdapter;
import ir.khorrami.mynewapp.api.ApiClient;
import ir.khorrami.mynewapp.databinding.ActivityBinderListBinding;
import ir.khorrami.mynewapp.model.Employee;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BinderListActivity extends AppCompatActivity {

    EmployeAdapter adapter;
    ApiClient apiClient;
ActivityBinderListBinding binding;
List<Employee> employeeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_binder_list);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_binder_list);

        Call<List<Employee>> call = ApiClient.GetInstance().GetApi().GetEmployee();

        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                employeeList = response.body();
                adapter = new EmployeAdapter(getApplicationContext(),employeeList);
                binding.rcvEmployeeList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                binding.rcvEmployeeList.setHasFixedSize(true);
                binding.rcvEmployeeList.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Toast.makeText(BinderListActivity.this, " Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}