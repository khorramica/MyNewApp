package ir.khorrami.mynewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ir.khorrami.mynewapp.adapter.EmployeAdapter;
import ir.khorrami.mynewapp.api.Api;
import ir.khorrami.mynewapp.api.ApiClient;
import ir.khorrami.mynewapp.model.Employee;
import ir.khorrami.mynewapp.model.StackOverFlow;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Api request;
    TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.text_Name);

        request = ApiClient.GetInstance().GetApi();

        Call<StackOverFlow> call = request.GetStackOFW("desc", "creation", "stackoverflow");
        call.enqueue(new Callback<StackOverFlow>() {
            @Override
            public void onResponse(Call<StackOverFlow> call, Response<StackOverFlow> response) {
                StackOverFlow stack = response.body();
                txtName.setText(String.valueOf(stack.getQuota_max()));
            }

            @Override
            public void onFailure(Call<StackOverFlow> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


//        Call<Employee> call = request.GetEmployee();
//
//        call.enqueue(new Callback<Employee>() {
//            @Override
//            public void onResponse(Call<Employee> call, Response<Employee> response) {
//                Employee employee = response.body();
//                txtName.setText(employee.getEmployeeName());
//            }
//
//            @Override
//            public void onFailure(Call<Employee> call, Throwable t) {
//                Toast.makeText(getApplicationContext(),"Error : " + t.getMessage(),Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}