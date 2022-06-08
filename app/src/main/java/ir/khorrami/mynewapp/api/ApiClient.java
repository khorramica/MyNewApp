package ir.khorrami.mynewapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL="https://localhost:7012/api/";
    Retrofit retrofit;
    static ApiClient apiClient;

    public ApiClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiClient GetInstance()
    {
        if(apiClient == null)
            apiClient = new ApiClient();

        return  apiClient;
    }

    public Api GetApi()
    {
        return retrofit.create(Api.class);
    }

}
