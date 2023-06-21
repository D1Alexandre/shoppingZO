package br.com.d1systems.shoppingzo.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import br.com.d1systems.shoppingzo.R;
import br.com.d1systems.shoppingzo.models.Notice;
import br.com.d1systems.shoppingzo.utils.globals;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {

    private List<Notice> NoticeList;
    private Context mContext;

    public NoticeAdapter(List<Notice> noticeList, Context mContext) {
        NoticeList = noticeList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public NoticeAdapter.NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notice, parent, false);
        NoticeViewHolder viewHolder = new NoticeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeAdapter.NoticeViewHolder holder, int position) {
        try {
            holder.bindNotice(NoticeList.get(position));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return NoticeList.size();
    }


    public class NoticeViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewNotice;
        TextView textViewNotice;

        public NoticeViewHolder(View itemView) {
            super(itemView);
            imageViewNotice = itemView.findViewById(R.id.imageViewNotice);
            textViewNotice = itemView.findViewById(R.id.textViewNotice);
        }

        public void bindNotice(Notice notice) throws UnsupportedEncodingException {
            if(notice.getTipo() == 0) {
                imageViewNotice.setVisibility(View.GONE);
                textViewNotice.setVisibility(View.VISIBLE);
                textViewNotice.setText(notice.getTexto());
            }else {
                try {
                    imageViewNotice.setVisibility(View.VISIBLE);
                    URL newurl = new URL(globals.getUrlServidor()+ "/openfile?arq=" +notice.getTexto());
                    Bitmap img = BitmapFactory.decodeStream(newurl.openConnection().getInputStream());
                    imageViewNotice.setImageBitmap(img);
                    textViewNotice.setVisibility(View.GONE);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
