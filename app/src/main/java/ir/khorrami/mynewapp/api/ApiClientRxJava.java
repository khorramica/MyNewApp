package ir.khorrami.mynewapp.api;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientRxJava {

    private static final String BASE_URL="http://10.0.2.2:5012/api/";
//    private static final String BASE_URL="http://10.0.2.2:5012/api/";
    //private static final String BASE_URL="https://127.0.0.1:7012/api/";
    //private static final String BASE_URL="https://localhost:7012/api/";
    //private static final String BASE_URL="https://192.168.50.77:7012/api/";
    //private static final String BASE_URL="https://api.stackexchange.com/2.3/";



    Retrofit retrofit;
    static ApiClientRxJava apiClientRxJava;

    public ApiClientRxJava() {
        OkHttpClient client = new OkHttpClient();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    

    public static ApiClientRxJava GetInstance()
    {
        if(apiClientRxJava == null)
            apiClientRxJava = new ApiClientRxJava();

        return  apiClientRxJava;
    }

    public Api GetApi()
    {
        return retrofit.create(Api.class);
    }

}
