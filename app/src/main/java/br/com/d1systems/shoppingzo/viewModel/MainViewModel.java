package br.com.d1systems.shoppingzo.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.d1systems.shoppingzo.models.Annouce;
import br.com.d1systems.shoppingzo.models.Notice;
import br.com.d1systems.shoppingzo.repository.AnnouceRepository;
import br.com.d1systems.shoppingzo.repository.NoticeRepository;


public class MainViewModel extends AndroidViewModel {
    private final NoticeRepository noticeRepository;
    private final AnnouceRepository annouceRepository;

    private MutableLiveData<List<Notice>> listOfNotices = new MutableLiveData<>();
    private MutableLiveData<List<Annouce>> listOfAnnouces = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
        this.annouceRepository = new AnnouceRepository();
        this.noticeRepository = new NoticeRepository();
    }

    public MutableLiveData<List<Notice>> loadNotices() {
        listOfNotices = noticeRepository.getlistOfNotices();
        return listOfNotices;
    }

    public MutableLiveData<List<Annouce>> loadAnnouces(){
        listOfAnnouces = annouceRepository.getlistOfAnnouces();
        return listOfAnnouces;
    }
}
