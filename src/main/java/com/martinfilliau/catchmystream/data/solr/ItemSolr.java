package com.martinfilliau.catchmystream.data.solr;

import java.util.List;
import org.apache.solr.client.solrj.beans.Field;

/**
 *
 * @author martinfilliau
 */
public class ItemSolr {

    @Field
    private String uri;
    
    @Field
    private String title;
    
    @Field
    private String author;

    @Field
    private String publishedDate;
    
    @Field
    private List<String> content;
    
    @Field
    private List<String> keywords;
    
    @Field
    private String source;
    
    @Field
    private boolean iAmTheAuthor;

    
    /* GETTERs and SETTERs */
    
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isiAmTheAuthor() {
        return iAmTheAuthor;
    }

    public void setiAmTheAuthor(boolean iAmTheAuthor) {
        this.iAmTheAuthor = iAmTheAuthor;
    }
    
}
