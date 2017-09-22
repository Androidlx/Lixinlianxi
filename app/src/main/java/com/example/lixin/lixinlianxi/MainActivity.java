package com.example.lixin.lixinlianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private TextView checked_shop;
    private TextView price;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = (ExpandableListView) findViewById(R.id.expandablelistview);
        adapter = new MyAdapter(MainActivity.this);
        expandableListView.setAdapter(adapter);
        final CheckBox checkAll = (CheckBox) findViewById(R.id.checkAll);
        price = (TextView) findViewById(R.id.price);
        checked_shop = (TextView) findViewById(R.id.checked_shop);
        checkAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置商品全部选中
                adapter.checkAllShop(checkAll.isChecked());
                //计算选中的价格和数量
                String shopPrice = adapter.getShopPrice();
                //判断商品是否全部选中
                boolean b = adapter.selectAll();

                String[] split = shopPrice.split(",");
                price.setText(split[0]);
                checked_shop.setText(split[1]);
                checkAll.setChecked(b);
            }
        });
        adapter.getAdapterData(new MyAdapter.AdapterData() {
            @Override
            public void Data(View v, String str, boolean b) {
                String[] split = str.split(",");
                price.setText(split[0]);
                checked_shop.setText(split[1]);
                checkAll.setChecked(b);
            }
        });

        checkAll.setChecked(adapter.selectAll());
        adapter.notifyDataSetChanged();

    }

}