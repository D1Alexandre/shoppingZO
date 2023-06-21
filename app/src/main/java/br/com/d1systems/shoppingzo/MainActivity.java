package br.com.d1systems.shoppingzo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.UnsupportedEncodingException;
import java.util.List;

import br.com.d1systems.shoppingzo.adapters.AnnouceAdapter;
import br.com.d1systems.shoppingzo.adapters.NoticeAdapter;
import br.com.d1systems.shoppingzo.models.Notice;
import br.com.d1systems.shoppingzo.viewModel.MainViewModel;

public class MainActivity extends AppCompatActivity  {

    MainViewModel mainViewModel;
    RecyclerView rcAvisos, rcAnuncios;
    TextView txtAvisos;
    NoticeAdapter noticeAdapter;
    AnnouceAdapter annouceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel =  new ViewModelProvider(this).get(MainViewModel.class);
        rcAvisos = (RecyclerView) findViewById(R.id.rcAvisos);
        txtAvisos = (TextView) findViewById(R.id.txtAvisos);
        rcAnuncios = (RecyclerView) findViewById(R.id.rcAnuncios);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        LinearLayoutManager lmWarnning = new LinearLayoutManager(this);
        lmWarnning.setOrientation(RecyclerView.HORIZONTAL);
        rcAvisos.setLayoutManager(lmWarnning);
        rcAvisos.setHasFixedSize(true);

        LinearLayoutManager lmAnnouces = new LinearLayoutManager(this);
        lmAnnouces.setOrientation(RecyclerView.VERTICAL);
        rcAnuncios.setLayoutManager(lmAnnouces);
        rcAnuncios.setHasFixedSize(true);

        mainViewModel.loadNotices().observe(this, listNotices -> {
            if(listNotices.isEmpty()){
                txtAvisos.setVisibility(View.GONE);
                rcAvisos.setVisibility(View.GONE);
            }else {
                noticeAdapter = new NoticeAdapter(listNotices, this);
                rcAvisos.setAdapter(noticeAdapter);
            }
        });

        mainViewModel.loadAnnouces().observe(this, listAnnouces -> {
            if(listAnnouces != null && !listAnnouces.isEmpty()){
                annouceAdapter = new AnnouceAdapter(listAnnouces, this);
                rcAnuncios.setAdapter(annouceAdapter);
            }
        });

    }
}