package site.ufsj.precos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentISupermercado extends Fragment {


    public FragmentISupermercado() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_fragment_isupermercado, container, false);

        Button btn = v.findViewById(R.id.buttonISup);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final PrecosInterface iPrecosREST = PrecosInterface.retrofit
                        .create(PrecosInterface.class);
                EditText editNome = getActivity().findViewById(R.id.editText);
                EditText editEnd = getActivity().findViewById(R.id.editTextEnd);
                EditText editCidade = getActivity().findViewById(R.id.editTextCid);
                final Call<Void> call = iPrecosREST.insereSupermercado(
                        new Supermercado(editNome.getText().toString(), editEnd.getText().toString(), editCidade.getText().toString()));
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response){
                        Toast.makeText(getActivity(), "Inserido com sucesso",
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(getActivity(), t.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });    }
        });

        // Inflate the layout for this fragment
        return v;

    }

}
