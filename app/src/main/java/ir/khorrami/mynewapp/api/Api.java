package ir.khorrami.mynewapp.api;

import ir.khorrami.mynewapp.model.Employee;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("Employee")
    Call<Employee> GetEmployee();

}
