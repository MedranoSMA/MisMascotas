package mx.carpediemsoft.lasmascotas;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


import mx.carpediemsoft.lasmascotas.adapter.MascotaAdaptador;
import mx.carpediemsoft.lasmascotas.adapter.PageAdapter;
import mx.carpediemsoft.lasmascotas.fragment.Perfilfragment;
import mx.carpediemsoft.lasmascotas.fragment.RecyclerViewFragment;
import mx.carpediemsoft.lasmascotas.poyo.Acerca_de;
import mx.carpediemsoft.lasmascotas.poyo.Contacto;
import mx.carpediemsoft.lasmascotas.poyo.Mascota;
import mx.carpediemsoft.lasmascotas.poyo.Mascotas5;


public class MainActivity extends AppCompatActivity {



    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> masc5fav;
    private RecyclerView listaMascotas;
    int nLikes = 0;

    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setTitle(null);

      /*  listaMascotas = (RecyclerView) findViewById(R.id.rvmascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();*/

        if (toolbar != null){
           setSupportActionBar(toolbar);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mAbout:
                Intent i=new Intent(this, Contacto.class);
                startActivity(i);
            break;

            case R.id.mSettings:
                Intent i2=new Intent (this, Acerca_de.class);
                startActivity(i2);
                break;

            case R.id.estrella:


                Collections.sort(mascotas, new Comparator<Mascota>() {
                    @Override
                    public int compare(Mascota mascota, Mascota t1) {
                        return new Integer(t1.getRating()).compareTo(new Integer(mascota.getRating()));
                    }
                });


                Intent intent = new Intent(this, Mascotas5.class);
                intent.putExtra("mascota1", mascotas.get(0));
                intent.putExtra("mascota2", mascotas.get(1));
                intent.putExtra("mascota3", mascotas.get(2));
                intent.putExtra("mascota4", mascotas.get(3));
                intent.putExtra("mascota5", mascotas.get(4));
                startActivity(intent);
               // break;
        }
        return super.onOptionsItemSelected(item);
    }

   /* public MascotaAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador =new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }*/

    private  ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new Perfilfragment());
        return fragments;

    }
    private void setUpViewPager(){
    viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_profile);
    }

  /*  public void inicializarListaMascotas(){
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

    }*/
}
