package br.com.d1systems.shoppingzo.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import br.com.d1systems.shoppingzo.R;
import br.com.d1systems.shoppingzo.models.Annouce;
import br.com.d1systems.shoppingzo.utils.globals;

public class AnnouceAdapter extends RecyclerView.Adapter<AnnouceAdapter.AnnouceViewHolder> {

    private List<Annouce> annouceList;
    private Context mContext;


    public AnnouceAdapter(List<Annouce> annouceList, Context mContext) {
        this.annouceList = annouceList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public AnnouceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_annouce, parent, false);
        AnnouceAdapter.AnnouceViewHolder viewHolder = new AnnouceAdapter.AnnouceViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull AnnouceViewHolder holder, int position) {
        try {
            holder.bindAnnouce(annouceList.get(position));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return annouceList.size();
    }

    public class AnnouceViewHolder extends RecyclerView.ViewHolder {
        CardView cardItemAnnouce;
        ImageView imageViewAnuncio;
        TextView textViewAnuncio;
        TextView textViewNomeLoja;
        TextView textViewPreco;

        public AnnouceViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewAnuncio = itemView.findViewById(R.id.imageViewAnuncio);
            textViewAnuncio = itemView.findViewById(R.id.textViewAnuncio);
            textViewNomeLoja = itemView.findViewById(R.id.textViewNomeLoja);
            textViewPreco = itemView.findViewById(R.id.textViewPreco);
            cardItemAnnouce = itemView.findViewById(R.id.cardItemAnnouce);
        }

        @SuppressLint("SetTextI18n")
        public void bindAnnouce(Annouce annouce) throws Exception {
            try {
                String nameImage = annouce.getFotoPrincipal() == null ? "shoppingZO.png" : annouce.getFotoPrincipal();
                imageViewAnuncio.setImageDrawable( getImagem(nameImage) );
                textViewAnuncio.setText( annouce.getNomeProduto() );

                Locale localeBR = new Locale( "pt", "BR" );
                NumberFormat dinheiroBR = NumberFormat.getCurrencyInstance(localeBR);

                textViewPreco.setText("Preço: "+dinheiroBR.format(annouce.getPrecoProduto()) );
                textViewNomeLoja.setText("Anunciante: "+annouce.getLoja() );

                cardItemAnnouce.setOnClickListener(view -> {
                    Toast.makeText(mContext, "Cliquei "+annouce.getNomeProduto(), Toast.LENGTH_SHORT).show();
                });

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public Drawable getImagem(String nameImage) throws Exception {
        URL newurl = new URL(globals.getUrlServidor()+ "/openfile?arq=" +nameImage);
        InputStream is = (InputStream) newurl.getContent();
        return Drawable.createFromStream(is, "src");
    }
}
