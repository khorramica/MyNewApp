package ir.khorrami.mynewapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ir.khorrami.mynewapp.R;
import ir.khorrami.mynewapp.api.Api;
import ir.khorrami.mynewapp.api.ApiClient;
import ir.khorrami.mynewapp.model.Employee;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Api request;
    TextView txtName,txtCity,txtNameByID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.txt_Name);
        txtCity = findViewById(R.id.txt_City);
        txtNameByID = findViewById(R.id.txt_nameByID);

        request = ApiClient.GetInstance().GetApi();

//        Call<StackOverFlow> call = request.GetStackOFW("desc", "creation", "stackoverflow");
//        call.enqueue(new Callback<StackOverFlow>() {
//            @Override
//            public void onResponse(Call<StackOverFlow> call, Response<StackOverFlow> response) {
//                StackOverFlow stack = response.body();
//                txtName.setText(String.valueOf(stack.getQuota_max()));
//            }
//
//            @Override
//            public void onFailure(Call<StackOverFlow> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//

        Call<List<Employee>> call = request.GetEmployee();

        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                Employee employee = response.body().get(0);
                txtName.setText(employee.getEmployeeName());
                txtCity.setText(employee.getCity());
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {

            }
        });

        Call<Employee> callByID = request.GetEmployeeByID(2);
        callByID.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {

                Employee employee = response.body();
                txtNameByID.setText(employee.getDateOfBirth());
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}