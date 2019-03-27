package com;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DataLinks {

    private ConcurrentLinkedQueue<String> unvisited = new ConcurrentLinkedQueue<String>();

    private ArrayList<String> visited = new ArrayList<String>();

    public DataLinks(String initial_url) {
        unvisited.offer(initial_url);
    }

    public void addURL(String url) {
        unvisited.offer(url);
    }

    public String getURL() {
        return unvisited.poll();
    }

    public int visit_size() {
        return unvisited.size();
    }

    public void addVisitedURL(String url) {
        visited.add(url);
    }


    public boolean oldLink(String link) {
        for(String s : visited) {
            if(s.equals(link)) {
                return true;
            }
        }
        return false;
    }
}

