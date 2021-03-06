package ir.khorrami.mynewapp.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL="http://10.0.2.2:5012/api/";
//    private static final String BASE_URL="http://10.0.2.2:5012/api/";
    //private static final String BASE_URL="https://127.0.0.1:7012/api/";
    //private static final String BASE_URL="https://localhost:7012/api/";
    //private static final String BASE_URL="https://192.168.50.77:7012/api/";
    //private static final String BASE_URL="https://api.stackexchange.com/2.3/";



    Retrofit retrofit;
    static ApiClient apiClient;

    public ApiClient() {
        OkHttpClient client = new OkHttpClient();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
               // .client(client)
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
