package teste.m.bloconotasactivity.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import teste.m.bloconotasactivity.NotasClickListener;
import teste.m.bloconotasactivity.R;
import teste.m.bloconotasactivity.db.entity.NotaEntity;

/**
 * {@link RecyclerView.Adapter} that can display a {@link NotaEntity} and makes a call to the
 * specified {@link NotasClickListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyNotaRecyclerViewAdapter extends RecyclerView.Adapter<MyNotaRecyclerViewAdapter.ViewHolder> {

    private final List<NotaEntity> mValues;
    private Context contexto;

    public MyNotaRecyclerViewAdapter(List<NotaEntity> items, Context context){
        this.mValues = items;
        this.contexto = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_nota, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tvTitle.setText(mValues.get(position).titulo);
        holder.tvConteudo.setText(mValues.get(position).conteudo);
        if(holder.mItem.isFavorido()){
            holder.ivFavorito.setImageResource(R.drawable.ic_star_black_24dp);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvTitle;
        public final TextView tvConteudo;
        public final ImageView ivFavorito;
        public NotaEntity mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvTitle = view.findViewById(R.id.textViewTitle);
            tvConteudo = view.findViewById(R.id.textViewConteudo);
            ivFavorito = view.findViewById(R.id.imageEstarFavorita);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvTitle.getText() + "'";
        }
    }
}
