package ir.khorrami.mynewapp.api;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import ir.khorrami.mynewapp.model.Employee;
import ir.khorrami.mynewapp.model.StackOverFlow;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {


    @GET("Employee")
    Single<List<Employee>> GetEmployeesByRxJava();

    @GET("Employee")
    Call<List<Employee>> GetEmployee();

    @GET("Employee/{id}")
    Call<Employee> GetEmployeeByID(@Path("id") int id);

    @GET("answers")
    Call<StackOverFlow> GetStackOFW(
            @Query("order") String order,
            @Query("sort") String sort,
            @Query("site") String stackoverflow
    );
}
