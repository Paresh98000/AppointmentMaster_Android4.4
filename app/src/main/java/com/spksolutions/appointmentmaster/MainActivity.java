package com.spksolutions.appointmentmaster;

import android.app.SearchManager;
import android.content.SearchRecentSuggestionsProvider;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.appcompat.widget.SearchView;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.spksolutions.appointmentmaster.R;

import com.spksolutions.appointmentmaster.data.Database;

import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private Database data;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_appointment, R.id.nav_service,
                R.id.nav_schedule,R.id.nav_message,
                R.id.nav_user_sign_in,R.id.nav_user_sign_up,
                R.id.nav_sp_sign_in,R.id.nav_sp_sign_up,
                R.id.nav_logout)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //data = new Database(getFileStreamPath("").getAbsolutePath());
    }

    @Override
    protected void onResume() {
        super.onResume();

        DatabaseProvider provider = new DatabaseProvider();
        provider.setPreferences(getPath(),getApplicationContext().getPackageName());
        provider.query(Uri.parse(provider.AUTHORITY+"/"+provider.TABLE_APPOINTMENT+"/22"),null,null,null,null);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryRefinementEnabled(true);
        //searchView.setIconifiedByDefault(false);


        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //Toast.makeText(getBaseContext(),item.getTitle().toString(),Toast.LENGTH_LONG).show();

        if(item.getItemId() == R.id.menu_search){
            //item.setVisible(true);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }

    public void logout(View v){
        LogoutDialog d = new LogoutDialog(this.getBaseContext());
        d.show();
    }

    public String getPath(){
        PackageManager manager = getPackageManager();
        String s = getPackageName();

        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(s,0);
        } catch (PackageManager.NameNotFoundException e) {
            return "/data/data/"+s;

        }
        return info.applicationInfo.dataDir;
    }
}
