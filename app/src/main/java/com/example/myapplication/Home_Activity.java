    package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private ListView list;

    private ListViewAdapter adapter;

    String[] listNama;

    String nama;

    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    Bundle bundle = new Bundle();

    Intent intent;

    private SearchView sCari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        listNama = new String[]{"Inayah","Ilham", "Eris",
                "Fikri","Maul","Intan","Vina","Gita",
                "Vian","Lutfi"};
        list = findViewById(R.id.listKontak);

        classNamaArrayList = new ArrayList<>();

        for (int i = 0; i < listNama.length; i++)
        {
            ClassNama classNama = new ClassNama(listNama[i]);

            classNamaArrayList.add(classNama);
        }

        adapter = new ListViewAdapter(this);

        list.setAdapter(adapter);

        SearchView searchView = findViewById(R.id.search);
        this.sCari = searchView;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String nama) {
                adapter.filter(nama);
                searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String nextText) {
                adapter.filter(nextText);
                return false;
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                nama = classNamaArrayList.get(position).getName();

                bundle.putString("a",nama.trim());

                PopupMenu pm = new PopupMenu(getApplicationContext(),view);

                pm.setOnMenuItemClickListener(Home_Activity.this);

                pm.inflate(R.menu.popup_menu);

                pm.show();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.mndata:
                intent = new Intent(getApplicationContext(), ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnnomor:
                switch (nama) {
                    case "Inayah":
                        Toast.makeText(getApplicationContext(), "081234567891",
                                Toast.LENGTH_LONG).show();
                        break;
                    case "Ilham":
                        Toast.makeText(getApplicationContext(), "081234567892",
                                Toast.LENGTH_LONG).show();
                        break;
                    case "Eris":
                        Toast.makeText(getApplicationContext(), "081234567893",
                                Toast.LENGTH_LONG).show();
                        break;
                    case "Fikri":
                        Toast.makeText(getApplicationContext(), "081234567894",
                                Toast.LENGTH_LONG).show();
                        break;
                    case "Maul":
                        Toast.makeText(getApplicationContext(), "081234567895",
                                Toast.LENGTH_LONG).show();
                        break;
                    case "Intan":
                        Toast.makeText(getApplicationContext(), "081234567896",
                                Toast.LENGTH_LONG).show();
                        break;
                    case "Vina":
                        Toast.makeText(getApplicationContext(), "081234567897",
                                Toast.LENGTH_LONG).show();
                        break;
                    case "Gita":
                        Toast.makeText(getApplicationContext(), "081234567898",
                                Toast.LENGTH_LONG).show();
                        break;
                    case "Lutfi":
                        Toast.makeText(getApplicationContext(), "081234567899",
                                Toast.LENGTH_LONG).show();
                        break;
                    case "Vian":
                        Toast.makeText(getApplicationContext(), "081234567890",
                                Toast.LENGTH_LONG).show();
                        break;
                }
                return false;
        }
        return false;
    }

}