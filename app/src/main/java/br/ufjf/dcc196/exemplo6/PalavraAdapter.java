package br.ufjf.dcc196.exemplo6;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PalavraAdapter extends RecyclerView.Adapter<PalavraAdapter.ViewHolder> {

    private final List<String> items;
    private OnPalavraClickListener listener;

    public PalavraAdapter(List<String> palavras) {
        this.items = palavras;
    }

    public void setOnpalabraClickListener(OnPalavraClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public PalavraAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View linha = inflater.inflate(R.layout.palavra_layout, parent, false);
        ViewHolder vh = new ViewHolder(linha);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PalavraAdapter.ViewHolder holder, int position) {
        String palavra = this.items.get(position);
        holder.txtPalavra.setText(palavra);
        holder.txtTamanho.setText(Integer.toString(palavra.length()));
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView txtPalavra;
        public TextView txtTamanho;

        public ViewHolder(View itemView) {
            super(itemView);
            txtPalavra = itemView.findViewById(R.id.txtPalavra);
            txtTamanho = itemView.findViewById(R.id.txtTamanho);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        listener.onPalavraClick(v, getAdapterPosition());
                    }
                }
            });

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if(position != RecyclerView.NO_POSITION){
                listener.onPalavraClick(v, getAdapterPosition());
            }
        }
    }

    public interface OnPalavraClickListener{
        public void onPalavraClick(View v, int adapterPosition);
    }
}
