package site.ufsj.precos;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultaPrecoFragment extends Fragment {

    EditText codigo_barras;

    public ConsultaPrecoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v =  inflater.inflate(R.layout.fragment_consulta_preco, container, false);
        Button btn = v.findViewById(R.id.buttonCodBarras);
        codigo_barras = v.findViewById(R.id.editTextCodBarras);

                btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = IntentIntegrator
                        .forSupportFragment(ConsultaPrecoFragment.this)
                        .createScanIntent();
                startActivityForResult(intent, IntentIntegrator.REQUEST_CODE);
            }
        });
        Button btnConsulta = v.findViewById(R.id.buttonCconsultaPreco);

        btnConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final PrecosInterface iPrecosREST = PrecosInterface.retrofit
                        .create(PrecosInterface.class);
                final RecyclerView recyclerViewPrecos = (RecyclerView) v.findViewById(R.id.rv);
                recyclerViewPrecos.setLayoutManager(new LinearLayoutManager(getActivity()));
                TextView tv = v.findViewById(R.id.editTextCodBarras);
                final Call<List<Superpreco>> call = iPrecosREST.getSuperprecoPorId(tv.getText().toString());
                call.enqueue(new Callback<List<Superpreco>>() {
                    @Override
                    public void onResponse(Call<List<Superpreco>> call, Response<List<Superpreco>> response){
                        recyclerViewPrecos.setAdapter(new ConsultaPrecoAdapter(response.body()));
                        TextView et = v.findViewById(R.id.textViewDescricao);
                        et.setText(response.body().get(0).getProduto());
                    }

                    @Override
                    public void onFailure(Call<List<Superpreco>> call, Throwable t) {
                        Toast.makeText(getActivity(), t.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });




            }
        });

        return v;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(getActivity(), "Escaneamento cancelado", Toast.LENGTH_LONG).show();
            } else {
                codigo_barras.setText(result.getContents());
                Toast.makeText(getActivity(), "Código escaneado: " + result.getContents(), Toast.LENGTH_LONG).show();
            }
        }
    }
}
