package ir.khorrami.mynewapp.api;

import ir.khorrami.mynewapp.model.Employee;
import ir.khorrami.mynewapp.model.StackOverFlow;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("Employee")
    Call<Employee> GetEmployee();

    @GET("answers")
    Call<StackOverFlow> GetStackOFW(
            @Query("order") String order,
            @Query("sort") String sort,
            @Query("site") String stackoverflow
    );
}
