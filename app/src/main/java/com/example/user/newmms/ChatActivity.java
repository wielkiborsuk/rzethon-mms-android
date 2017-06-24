package com.example.user.newmms;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.user.newmms.communication.ApiServiceFactory;
import com.example.user.newmms.model.Message;
import com.example.user.newmms.model.MessageForm;

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
    }

    public void sendMessage(final View view) {
        EditText content = ((EditText) findViewById(R.id.message_content));
        EditText name = ((EditText) findViewById(R.id.message_name));

        MessageForm form = new MessageForm();
        MessageForm.Message message = new MessageForm.Message();
        message.setContent(content.getText().toString());
        message.setReceiver(content.getText().toString());
        message.setDestination("MARS#1.1");
        message.setSender("borsuk");
        message.setSpeedFactor(1.0);
        form.setMessage(message);

        ApiServiceFactory.createService("http://10.0.2.2:3000/", "borsuk").sendMessage(form).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Snackbar.make(view, "Your message got id: " + response.body().getMessage().getId(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
