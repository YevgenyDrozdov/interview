package com.playtika.interview;

public class Message {

    private Topic topic;
    private int id;
    private String body;

    public Message(Topic topic, int id, String body) {
        this.topic = topic;
        this.id = id;
        this.body = body;
    }

    public Topic getTopic() {
        return topic;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

}
