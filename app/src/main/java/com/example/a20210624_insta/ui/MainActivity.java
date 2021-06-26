package com.example.a20210624_insta.ui;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.example.a20210624_insta.R;
import com.example.a20210624_insta.databinding.NavHeaderMainBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a20210624_insta.databinding.ActivityMainBinding;

import java.util.Random;

import dagger.hilt.android.AndroidEntryPoint;

//힐트 적용을 위해 삽입
@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //액티비티 생성시 강의와 다르게 데이터바인딩이 적용되어 있음
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //ViewModel을 적용하기 위해서 사용
        //MainViewModel vm = new MainViewModel();

        //ViewModelProvider를 사용해 ViewModel 구성
        //힐트 생성으로 MainViewModel 객체 생성시 생성자의 매개변수로 application을 넘겨줘야하지만 힐트가 알아서 생성 후 넘겨줌
        //힐트 사용으로 MemberService 매개변수를 개체로 만들어 자동으로 넘겨주지만 내부 구성은 해줘야함
        MainViewModel vm = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setMainVm(vm);

        NavHeaderMainBinding navHeaderMainBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.nav_header_main, binding.navView, false);
        navHeaderMainBinding.setLifecycleOwner(this);
        navHeaderMainBinding.setMainVm(vm);
        binding.navView.addHeaderView(navHeaderMainBinding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(binding.drawerLayout)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}