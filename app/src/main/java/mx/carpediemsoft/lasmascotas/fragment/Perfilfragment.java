package mx.carpediemsoft.lasmascotas.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.carpediemsoft.lasmascotas.MainActivity;
import mx.carpediemsoft.lasmascotas.R;
import mx.carpediemsoft.lasmascotas.adapter.MascotaAdaptador;
import mx.carpediemsoft.lasmascotas.poyo.Mascota;


/**
 * A simple {@link Fragment} subclass.
 */
public class Perfilfragment extends Fragment {

    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> masc5fav;
    private RecyclerView listaMascotas;
    int nLikes = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvmascotas);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);
        glm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(glm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }
    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.bulldog, R.drawable.h2, "             Cheyenne", nLikes, R.drawable.h1));
        mascotas.add(new Mascota(R.drawable.cute, R.drawable.h2, "                  Gata", nLikes, R.drawable.h1));
        mascotas.add(new Mascota(R.drawable.cutedog, R.drawable.h2, "               Doggy", nLikes, R.drawable.h1));
        mascotas.add(new Mascota(R.drawable.dog, R.drawable.h2, "                 Pancho", nLikes, R.drawable.h1));
        mascotas.add(new Mascota(R.drawable.dogs, R.drawable.h2, "                  Scar",  nLikes, R.drawable.h1));
        mascotas.add(new Mascota(R.drawable.hamster, R.drawable.h2, "               Noruego", nLikes, R.drawable.h1));
        mascotas.add(new Mascota(R.drawable.loro, R.drawable.h2, "                  Paco",  nLikes, R.drawable.h1));
        mascotas.add(new Mascota(R.drawable.tortuga, R.drawable.h2, "               Donatello", nLikes, R.drawable.h1));
        mascotas.add(new Mascota(R.drawable.bulldog, R.drawable.h2, "             Cheyenne", nLikes, R.drawable.h1));

    }

    public MascotaAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador =new MascotaAdaptador(mascotas, (MainActivity) getActivity());
        listaMascotas.setAdapter(adaptador);
    }
    public Perfilfragment() {
        // Required empty public constructor
    }


  /*  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfilfragment, container, false);
    }
*/
}
