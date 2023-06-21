package br.com.d1systems.shoppingzo.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import br.com.d1systems.shoppingzo.models.Notice;
import br.com.d1systems.shoppingzo.utils.ConnectionService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NoticeRepository {
    private static ConnectionService myInterface;
    private static NoticeRepository noticeRepository;

    private final MutableLiveData<List<Notice>> listOfNotices = new MutableLiveData<>();

    public static NoticeRepository getInstance(){
        if (noticeRepository == null){
            noticeRepository = new NoticeRepository();
        }
        return noticeRepository;
    }

    public NoticeRepository(){
        myInterface = ConnectionService.getInterface();
    }

    public MutableLiveData<List<Notice>> getlistOfNotices() {
        myInterface.getNotices().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(result -> result)
                .subscribe(
                        listaNotcies ->{
                            listOfNotices.setValue( listaNotcies );
                        },
                        throwable -> {
                            Log.i("getlistOfNotices", throwable.getMessage() );
                            listOfNotices.postValue( new ArrayList<Notice>() );
                        }
                );

        return listOfNotices;
    }

}
