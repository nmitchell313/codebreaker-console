package edu.cnm.deepdive.codebreaker.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface WebServiceProxy {

    class InstanceHolder {

        private static final WebServiceProxy INSTANCE;

        static {
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://ddc-java.service/codebreaker/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            INSTANCE = retrofit.create(WebServiceProxy.class);
        }
    }
}

