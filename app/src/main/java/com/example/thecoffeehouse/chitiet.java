package com.example.thecoffeehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.thecoffeehouse.Models.DuocDatNhieuItem;

import java.util.ArrayList;

public class chitiet extends AppCompatActivity {

    ListView lv;
    DuocDatNhieuAdapter adapter;
    ArrayList<DuocDatNhieuItem> arr_bean;
    ImageView chitiet_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet2);
        chitiet_back=findViewById(R.id.chitiet_back);

        chitiet_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //Listview
        lv = (ListView) findViewById(R.id.list_dn);
        arr_bean=new ArrayList<DuocDatNhieuItem>();
        arr_bean.add(new DuocDatNhieuItem(R.drawable.bap, "Gà sốt cay Hàn Quốc","Bán chạy nhất của quán","46,000đ"));
        arr_bean.add(new DuocDatNhieuItem(R.drawable.bap, "Gà sốt cay Hàn Quốc","Bán chạy nhất của quán","46,000đ"));
        arr_bean.add(new DuocDatNhieuItem(R.drawable.bap, "Gà sốt cay Hàn Quốc","Bán chạy nhất của quán","46,000đ"));
        arr_bean.add(new DuocDatNhieuItem(R.drawable.bap, "Gà sốt cay Hàn Quốc","Bán chạy nhất của quán","46,000đ"));
        arr_bean.add(new DuocDatNhieuItem(R.drawable.bap, "Gà sốt cay Hàn Quốc","Bán chạy nhất của quán","46,000đ"));
        arr_bean.add(new DuocDatNhieuItem(R.drawable.bap, "Gà sốt cay Hàn Quốc","Bán chạy nhất của quán","46,000đ"));
        adapter=new DuocDatNhieuAdapter(arr_bean,this);
        lv.setAdapter(adapter);
    }
}