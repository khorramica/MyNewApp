package ir.khorrami.mynewapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import ir.khorrami.mynewapp.R;
import ir.khorrami.mynewapp.adapter.EmployeAdapter;
import ir.khorrami.mynewapp.api.Api;
import ir.khorrami.mynewapp.api.ApiClient;
import ir.khorrami.mynewapp.model.Employee;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowListActivity extends AppCompatActivity {
RecyclerView rcvEmployees;
    Api request;
    EmployeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        rcvEmployees = findViewById(R.id.rcv_Employees);
        request = ApiClient.GetInstance().GetApi();


        Call<List<Employee>> call = request.GetEmployee();

        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                List<Employee> employees = response.body();
                rcvEmployees.setHasFixedSize(true);
                rcvEmployees.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                adapter = new EmployeAdapter(getApplicationContext(),employees);
                rcvEmployees.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {

            }
        });

    }
}