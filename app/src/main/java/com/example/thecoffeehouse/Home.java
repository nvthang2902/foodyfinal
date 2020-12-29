package com.example.thecoffeehouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thecoffeehouse.Common.Category;
import com.example.thecoffeehouse.Interface.ItemClickListener;
import com.example.thecoffeehouse.ViewHolder.MenuViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference category;
    TextView txtFullName;
    RecyclerView recycler_menu;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<Category, MenuViewHolder> adapter;

    Button btnSignUp,btnSignIn;
    ImageView img1,khampha,giaohang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        database=FirebaseDatabase.getInstance();
        category=database.getReference("Foods");

        //Load Menu
        recycler_menu =(RecyclerView) findViewById(R.id.recycle_view);
        recycler_menu.setHasFixedSize(true);
        //layoutManager=new LinearLayoutManager(this);
        //recycler_menu.setLayoutManager(layoutManager);
        recycler_menu.setLayoutManager(new GridLayoutManager(this,2));

        loadMenu();

        btnSignIn = (Button) findViewById(R.id.si);
//        img1= findViewById(R.id.img11);
        khampha= findViewById(R.id.khampha);
        giaohang= findViewById(R.id.giaohang);


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent si=new Intent(Home.this,Login.class);
                startActivity(si);
            }
        });

        //

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.news);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.news:
//                        startActivity(new Intent(getApplicationContext(),Home.class));
//                        overridePendingTransition(0,0);
                        return true;
                    case R.id.delivery:
                        startActivity(new Intent(getApplicationContext(),orderScreen.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.donhang:
                        startActivity(new Intent(getApplicationContext(),donhang_screen.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.store:
                        startActivity(new Intent(getApplicationContext(),store_screen.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.account:
                        startActivity(new Intent(getApplicationContext(),account_screen.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
    }

    private void loadMenu() {
        adapter=new  FirebaseRecyclerAdapter<Category, MenuViewHolder>(Category.class,R.layout.menu_itemhome,MenuViewHolder.class,category) {
            @Override
            protected void populateViewHolder(MenuViewHolder menuViewHolder, Category model, final int i) {
                menuViewHolder.txtMenuName.setText(model.getName());
                Picasso.get().load(model.getImage()).into(menuViewHolder.imageView);
                final Category clickItem=model;
                menuViewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
//                        Toast.makeText(Home.this,""+clickItem.getName(),Toast.LENGTH_SHORT).show();
                        //Get CategoryId and send to new Activity
                        Intent foodList1=new Intent(Home.this,chitiet.class);

                        startActivity(foodList1);
                    }
                });
            }
        };
        recycler_menu.setAdapter(adapter);



//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setSelectedItemId(R.id.donhang);
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.news:
//                        startActivity(new Intent(getApplicationContext(), Home.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.delivery:
//                        startActivity(new Intent(getApplicationContext(), orderScreen.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.store:
//                        startActivity(new Intent(getApplicationContext(), store_screen.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.account:
//                        startActivity(new Intent(getApplicationContext(),account_screen.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.donhang:
////                        startActivity(new Intent(getApplicationContext(),donhang_screen.class));
////                        overridePendingTransition(0,0);
//                        return true;
//                }
//                return false;
//            }
//        });
    }

//    public void setRecycle_uudai(List<item> itemList ){
//        recycleuudai=findViewById(R.id.recycle_uudai);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
//        recycleuudai.setLayoutManager(layoutManager);
//        itemAdapter = new itemAdapter(this,itemList);
//        recycleuudai.setAdapter(itemAdapter);
//    }
//    public void setRecyclecapnhat(List<item> itemList ){
//        recyclecapnhat=findViewById(R.id.recycle_capnhat);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
//        recyclecapnhat.setLayoutManager(layoutManager);
//        itemAdapter = new itemAdapter(this,itemList);
//        recyclecapnhat.setAdapter(itemAdapter);
//    }
//    public void setRecycle_lover(List<item> itemList ){
//        recycle_lover=findViewById(R.id.recycle_lover);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
//        recycle_lover.setLayoutManager(layoutManager);
//        itemAdapter = new itemAdapter(this,itemList);
//        recycle_lover.setAdapter(itemAdapter);
//    }


}