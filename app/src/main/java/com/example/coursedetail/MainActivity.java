package com.example.coursedetail;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursedetail.Adapter.RVAdapter;
import com.example.coursedetail.Fragment.ServiceDialogFragment;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView tvService;
    private TextView tvShoppingCart;
    private TextView tvJoinShoppingCart;
    private TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        init();
        setAdapter();

        Drawable dService = getResources().getDrawable(R.drawable.coursedetails_customerservice_icon);
        dService.setBounds(0, 0, 80, 80);
        tvService.setCompoundDrawables(null, dService, null, null);

        Drawable dShoppingCart = getResources().getDrawable(R.drawable.coursedetails_shoppingcart_icon_normal);
        dShoppingCart.setBounds(0, 0, 80, 80);
        tvShoppingCart.setCompoundDrawables(null, dShoppingCart, null, null);

        tvService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "已经联系客服", Toast.LENGTH_SHORT).show();
            }
        });

        tvShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "已经加入购物车", Toast.LENGTH_SHORT).show();
            }
        });

        tvJoinShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "已经加入购物车", Toast.LENGTH_SHORT).show();
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "已经报名成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void init() {
        recyclerView = findViewById(R.id.rv_main_page);
        tvService = findViewById(R.id.tv_service);
        tvShoppingCart = findViewById(R.id.tv_shoppingCart);
        tvJoinShoppingCart = findViewById(R.id.tv_shopping_cart_join);
        tvRegister = findViewById(R.id.tv_register);
    }

    public void setAdapter() {
        RVAdapter adapter = new RVAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void onClick(View v) {
        String[] content;
        if (v.getId() == R.id.cl_service1) {
            content = getResources().getStringArray(R.array.item2);
            ServiceDialogFragment serviceDialogFragment = new ServiceDialogFragment(this, content);
            serviceDialogFragment.show(getSupportFragmentManager(), "");
        }
        if (v.getId() == R.id.cl_service2) {
            content = getResources().getStringArray(R.array.item3);
            ServiceDialogFragment serviceDialogFragment = new ServiceDialogFragment(this, content);
            serviceDialogFragment.show(getSupportFragmentManager(), "");
        }
    }
}
