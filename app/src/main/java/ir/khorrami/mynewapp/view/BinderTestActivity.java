package ir.khorrami.mynewapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import ir.khorrami.mynewapp.R;
import ir.khorrami.mynewapp.api.ApiClient;
import ir.khorrami.mynewapp.databinding.ActivityBinderTestBinding;
import ir.khorrami.mynewapp.model.Employee;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BinderTestActivity extends AppCompatActivity {

    ApiClient apiClient;


    ActivityBinderTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binder_test);

        Call<Employee> call = ApiClient.GetInstance().GetApi().GetEmployeeByID(2);

        call.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {

                //Employee employee = new Employee("Donya Khorrami","01-01-2018","Tehran");
                Employee employee = response.body();
                binding.setEmployeHelper(employee);
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText(BinderTestActivity.this, " Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}