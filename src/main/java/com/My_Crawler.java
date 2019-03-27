package com;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class My_Crawler extends Thread{

    DataLinks data;
    private final int INDEX_LIMIT = 10;

    /** Initial URL to visit **/
    public My_Crawler(DataLinks d) {
        data = d;
    }

    public void run() {
        int counter = 0;
        while((data.visit_size() > 0) && counter<INDEX_LIMIT) {
            String currentUrl = data.getURL();
            try {
                Document doc = Jsoup.connect(currentUrl).timeout(0).followRedirects(true).get();
                counter++;
                Elements links = doc.select("a[href]");
                linksOnThePage(links);
            } catch (IOException e) {
                System.out.println("Error: "+currentUrl);
            }
        }
    }

    public void linksOnThePage(Elements el) {
        for(Element e : el) {
            String theLink = e.attr("href");
            if(theLink.startsWith("http") && !data.oldLink(theLink)) {
                data.addURL(theLink);
                data.addVisitedURL(theLink);
                System.out.println(theLink);
            }
        }
    }
}
