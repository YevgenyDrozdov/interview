package com.playtika.interview;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class MessageOutputChannel {
    private HashMap<Topic, List<String>> topics = new HashMap<>();
    private TreeSet<Topic> excludedTopics = new TreeSet<>();

    private int counter = 0;

    public String read(String t){
        return topics.entrySet().stream().filter(entry -> entry.getKey().getName().equals(t)).map(entry -> entry.getValue())
                .findFirst().filter(messages -> !messages.isEmpty()).map(messages -> messages.remove(0)).orElse(null);
    }

    public void send(Message message){
        if(filter(message)){
            if(!topics.containsKey(message.getTopic()))
                topics.put(message.getTopic(), new ArrayList<>());

            topics.get(message.getTopic()).add(convert(message));
            counter++;
        }
    }

    private String convert(Message message){
        return MessageFormat.format("{\"id\": {0}, \"body\": {1}}", message.getId(), message.getBody());
    }

    public void setExcludedTopics(TreeSet<Topic> t){
        this.excludedTopics = t;
    }

    public boolean filter(Message message){
        return !excludedTopics.contains(message.getTopic());
    }

    public int getSentMessagesCounter(){
        return counter;
    }
}


