package br.com.d1systems.shoppingzo.utils;

import java.util.List;

import br.com.d1systems.shoppingzo.models.Annouce;
import br.com.d1systems.shoppingzo.models.Notice;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ConnectionService {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(globals.getUrlServidor())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("avisos")
    Observable<List<Notice>> getNotices();

    @GET("anuncios")
    Observable<List<Annouce>> getAnnouces();


    public static ConnectionService getInterface() {
        return retrofit.create(ConnectionService.class);
    }

}
