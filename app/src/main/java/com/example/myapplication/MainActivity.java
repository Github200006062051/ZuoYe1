package com.example.myapplication;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.adapter.ViewpagerAdapter;
import com.example.myapplication.contacts.ContactsFragment;
import com.example.myapplication.message.MessageFragement;
import com.example.myapplication.qzone.QzoneFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mIdViewPager;
    private TabLayout mIdTable;
    private NavigationView mIdNavigation;
    private DrawerLayout midDrawer;
    private QzoneFragment qzoneFragment;
    private MessageFragement messageFragement;
    private ContactsFragment contactsFragment;
    private Toolbar toolbar;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mIdViewPager = (ViewPager) findViewById(R.id.id_viewPager);
        mIdTable = (TabLayout) findViewById(R.id.id_Table);
        mIdNavigation = (NavigationView) findViewById(R.id.id_navigation);
        midDrawer = findViewById(R.id.id_drawer);
        toolbar = findViewById(R.id.id_Toobar);
        toolbar.setTitle("消息");
        qzoneFragment = new QzoneFragment();
        messageFragement = new MessageFragement();
        contactsFragment = new ContactsFragment();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(messageFragement);
        fragments.add(contactsFragment);
        fragments.add(qzoneFragment);
        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager(), fragments);
        mIdViewPager.setAdapter(viewpagerAdapter);
        mIdTable.setupWithViewPager(mIdViewPager);
        mIdTable.getTabAt(0).setCustomView(root("消息",R.drawable.sendmessage));
        mIdTable.getTabAt(1).setCustomView(root("联系人",R.drawable.im));
        mIdTable.getTabAt(2).setCustomView(root("动态",R.drawable.dongtai));
        mIdNavigation.setItemIconTintList(null);
        mIdTable.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position==0){
                    toolbar.setTitle("消息");
                }else if (position == 1){
                    toolbar.setTitle("联系人");
                }else if (position == 2){
                    toolbar.setTitle("动态");
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, midDrawer, toolbar, R.string.open, R.string.close);
        midDrawer.addDrawerListener(toggle);
        toggle.syncState();

    }
    public View root(String s,int res){
         View root = LayoutInflater.from(this).inflate(R.layout.root,null);
        ImageView image = root.findViewById(R.id.image);
        TextView title = root.findViewById(R.id.title);
        image.setImageResource(res);
        title.setText(s);
        return root;
    }
}
