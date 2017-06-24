package com.example.user.newmms;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.user.newmms.communication.ApiServiceFactory;
import com.example.user.newmms.model.Node;
import com.example.user.newmms.model.Simulation;
import com.example.user.newmms.model.Simulations;
import com.example.user.newmms.views.SimulationsAdapter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */

//            List<Node> nodes = ApiServiceFactory.createService("http://10.0.2.2:3000/", "borsuk").getNodeList().execute().body().getNodes();

        Log.i("myApp","go!");
        ApiServiceFactory.createService("http://10.0.2.2:3000/", "borsuk")
                .getSimulationList().enqueue(new Callback<Simulations>() {
            @Override
            public void onResponse(Call<Simulations> call, Response<Simulations> response) {
                ArrayAdapter<Simulation> adapter = new SimulationsAdapter(getApplicationContext(), response.body().getMessages());
                ((ListView)findViewById(R.id.sentMessages)).setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Simulations> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, ChatActivity.class);

        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);

            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
