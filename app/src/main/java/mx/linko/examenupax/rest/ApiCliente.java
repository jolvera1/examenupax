package mx.linko.examenupax.rest;

import android.content.Context;
import android.util.Log;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import mx.linko.examenupax.config.WebConfig;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import pl.droidsonroids.retrofit2.JspoonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCliente {

    public static Retrofit retrofit= null;
    public static Retrofit retrofitJson= null;
    public static Retrofit getClientJson(final Context context) {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(15, TimeUnit.SECONDS);
        httpClient.interceptors().add(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {

                Request original = chain.request();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .header("accept", "application/json")
                        .header("connection", "keep-alive")
                        .header("content-Type", "application/json")
                        ;

                Request request = requestBuilder.build();

                // try the request
                okhttp3.Response response = chain.proceed(request);

                int tryCount = 0;

                while (!response.isSuccessful() && tryCount < 3) {

                    Log.d("intercept", "Request is not successful - " + tryCount + " " + response.request().url());

                    tryCount++;

                    // retry the request
                    response = chain.proceed(request);
                }

                // otherwise just pass the original response on
                return response;
            }
        });

        OkHttpClient client = httpClient.build();
        retrofitJson = new Retrofit.Builder()
                .baseUrl("https://super.walmart.com.mx/api/rest/model/atg/commerce/catalog/ProductCatalogActor/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofitJson;
    }
    public static Retrofit getClient(final  String link,final Context context) {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(15, TimeUnit.SECONDS);
        httpClient.interceptors().add(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {

                Request original = chain.request();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder();

                Request request = requestBuilder.build();

                // try the request
                okhttp3.Response response = chain.proceed(request);

                int tryCount = 0;

                while (!response.isSuccessful() && tryCount < 3) {

                    Log.d("intercept", "Request is not successful - " + tryCount + " " + response.request().url());

                    tryCount++;

                    // retry the request
                    response = chain.proceed(request);
                }

                // otherwise just pass the original response on
                return response;
            }
        });

        OkHttpClient client = httpClient.build();
        retrofitJson = new Retrofit.Builder()
                .baseUrl(link)
                .addConverterFactory(JspoonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();

        return retrofitJson;
    }
    public static Retrofit getClient(final Context context) {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(15, TimeUnit.SECONDS);
        httpClient.interceptors().add(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {

                Request original = chain.request();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder();

                Request request = requestBuilder.build();

                // try the request
                okhttp3.Response response = chain.proceed(request);

                int tryCount = 0;

                while (!response.isSuccessful() && tryCount < 3) {

                    Log.d("intercept", "Request is not successful - " + tryCount + " " + response.request().url());

                    tryCount++;

                    // retry the request
                    response = chain.proceed(request);
                }

                // otherwise just pass the original response on
                return response;
            }
        });

        OkHttpClient client = httpClient.build();
        retrofitJson = new Retrofit.Builder()
                .baseUrl(WebConfig.HOST)
                .addConverterFactory(JspoonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();

        return retrofitJson;
    }

}
