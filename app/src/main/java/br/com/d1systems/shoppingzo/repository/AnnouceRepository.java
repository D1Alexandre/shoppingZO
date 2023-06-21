package br.com.d1systems.shoppingzo.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import br.com.d1systems.shoppingzo.models.Annouce;
import br.com.d1systems.shoppingzo.models.Notice;
import br.com.d1systems.shoppingzo.utils.ConnectionService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AnnouceRepository {
    private static ConnectionService conInterface;
    private static AnnouceRepository annouceRepository;

    private final MutableLiveData<List<Annouce>> listOfAnnouces = new MutableLiveData<>();

    public static AnnouceRepository getInstance(){
        if (annouceRepository == null){
            annouceRepository = new AnnouceRepository();
        }
        return annouceRepository;
    }

    public AnnouceRepository(){
        conInterface = ConnectionService.getInterface();
    }

    public MutableLiveData<List<Annouce>> getlistOfAnnouces() {
        conInterface.getAnnouces().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(result -> result)
                .subscribe(
                        annouces -> {
                            listOfAnnouces.setValue( annouces );
                        }, throwable -> {
                            Log.i("getlistOfAnnouces", throwable.getMessage() );
                            listOfAnnouces.postValue( new ArrayList<Annouce>() );
                        }

                );

        return listOfAnnouces;
    }

}
