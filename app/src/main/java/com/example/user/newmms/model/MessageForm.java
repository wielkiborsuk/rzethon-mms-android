package com.example.user.newmms.model;

public class MessageForm {

    private Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public static class Message {
        private String sender;
        private String receiver;
        private String destination;
        private String content;
        private double speedFactor;

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

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public double getSpeedFactor() {
            return speedFactor;
        }

        public void setSpeedFactor(double speedFactor) {
            this.speedFactor = speedFactor;
        }
    }
}
