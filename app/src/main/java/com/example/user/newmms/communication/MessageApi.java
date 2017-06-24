package com.example.user.newmms.communication;

import com.example.user.newmms.model.Message;
import com.example.user.newmms.model.MessageForm;
import com.example.user.newmms.model.Messages;
import com.example.user.newmms.model.Node;
import com.example.user.newmms.model.Nodes;
import com.example.user.newmms.model.Simulations;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MessageApi {
    @GET("nodes")
    public Call<Nodes> getNodeList();

    @GET("simulations")
    public Call<Simulations> getSimulationList();

    @GET("messages/sent")
    public Call<Messages> getSentMessages();

    @GET("messages/received")
    public Call<Messages> getReceivedMessages();

    @POST("messages")
    public Call<Message> sendMessage(@Body MessageForm messageForm);
}
