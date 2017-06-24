package com.example.user.newmms;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.user.newmms.communication.ApiServiceFactory;
import com.example.user.newmms.model.Message;
import com.example.user.newmms.model.MessageForm;
import com.example.user.newmms.model.Node;
import com.example.user.newmms.model.Nodes;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        Log.w("myApp", "start!");
        ApiServiceFactory.createService(pref.getString("host", ""), pref.getString("login", "")).getNodeList().enqueue(new Callback<Nodes>() {
            @Override
            public void onResponse(Call<Nodes> call, Response<Nodes> response) {
                Log.w("myApp", "hey!");
                List<String> names =  new ArrayList<String>();
                for (Node node : response.body().getNodes()) {
                    names.add(node.getName());
                }
                Log.w("myApp", names.toString());

                Spinner destinations = (Spinner) findViewById(R.id.message_destination);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(ChatActivity.this, android.R.layout.simple_spinner_dropdown_item, names.toArray(new String[0]));
                destinations.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Nodes> call, Throwable t) {
                Log.w("myApp", "fail");
                t.printStackTrace();
            }
        });
    }

    public void sendMessage(final View view) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        EditText content = ((EditText) findViewById(R.id.message_content));
        EditText name = ((EditText) findViewById(R.id.message_name));
        Spinner destinations = (Spinner) findViewById(R.id.message_destination);

        MessageForm form = new MessageForm();
        MessageForm.Message message = new MessageForm.Message();
        message.setContent(content.getText().toString());
        message.setReceiver(name.getText().toString());
        message.setDestination(destinations.getSelectedItem().toString());
        message.setSender(pref.getString("login", ""));
        message.setSpeedFactor(1.0);
        form.setMessage(message);

        ApiServiceFactory.createService(pref.getString("host", ""), pref.getString("login", "")).sendMessage(form).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Snackbar.make(view, "Your message got id: " + response.body().getMessage().getId(), Snackbar.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
