package com.example.user.newmms.model;

import java.util.Date;

public class Message {

    private InnerMessage message;

    public InnerMessage getMessage() {
        return message;
    }

    public void setMessage(InnerMessage message) {
        this.message = message;
    }

    public static class InnerMessage {
        private String id;
        private String content;
        private String source;
        private String destination;
        private Date created_at;
        private Date updated_at;
        private String sender;
        private String receiver;
        private double speed_factor;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public Date getCreated_at() {
            return created_at;
        }

        public void setCreated_at(Date created_at) {
            this.created_at = created_at;
        }

        public Date getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(Date updated_at) {
            this.updated_at = updated_at;
        }

        public String getSender() {
            return sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }

        public String getReceiver() {
            return receiver;
        }

        public void setReceiver(String receiver) {
            this.receiver = receiver;
        }

        public double getSpeed_factor() {
            return speed_factor;
        }

        public void setSpeed_factor(double speed_factor) {
            this.speed_factor = speed_factor;
        }
    }
}
