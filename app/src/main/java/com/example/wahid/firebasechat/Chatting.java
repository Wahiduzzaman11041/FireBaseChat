package com.example.wahid.firebasechat;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;


public class Chatting extends AppCompatActivity {


    SectionPageAdepter sectionPageAdepter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        Toast.makeText(Chatting.this,"Log in Successful",Toast.LENGTH_SHORT).show();

        Toolbar toolbar = findViewById(R.id.manu_bar_id);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("hello");


        viewPager = findViewById(R.id.tabPagerId);
        sectionPageAdepter = new SectionPageAdepter(getSupportFragmentManager());

        viewPager.setAdapter(sectionPageAdepter);

        tabLayout = findViewById(R.id.tabLayoutId);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_manu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId()==R.id.action_logout)
        {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(Chatting.this,"Log out",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Chatting.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

        return true;
    }
}
