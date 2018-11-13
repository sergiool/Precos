package site.ufsj.precos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ConsultaPrecoAdapter extends RecyclerView.Adapter <ConsultaPrecoAdapter.CursoItemViewHolder>{

    private List<Superpreco> mLista;

    public ConsultaPrecoAdapter(List<Superpreco> superprecos) {
        this.mLista = superprecos;
    }


    @NonNull
    @Override
    public CursoItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.consultapreco, parent, false);
        return new CursoItemViewHolder(layoutView, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull CursoItemViewHolder cursoItemViewHolder, int i) {
        Superpreco preco = mLista.get(i);
        cursoItemViewHolder.textViewSup.setText(preco.getSupermercado());
        cursoItemViewHolder.textViewPreco.setText(new Float(preco.getPreco()).toString());
    }

    @Override
    public int getItemCount() {
        return mLista.size();
    }

    public class CursoItemViewHolder extends RecyclerView.ViewHolder {
        TextView textViewSup;
        TextView textViewPreco;

        public CursoItemViewHolder(View itemView, final Context context) {
            super(itemView);

            textViewSup = (TextView) itemView.findViewById(R.id.textViewSup);
            textViewPreco = (TextView) itemView.findViewById(R.id.textViewPreco);
            //Layout l = (Layout) itemView.findViewById(R.id.recycler_curso_item);
        }
    }


}
