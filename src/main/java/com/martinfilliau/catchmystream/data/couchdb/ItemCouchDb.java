package com.martinfilliau.catchmystream.data.couchdb;

import java.util.Date;
import java.util.List;
import org.ektorp.support.CouchDbDocument;

/**
 * CouchDb view of an item
 * NOTE: strong dependency on {@link org.ektorp.support.CouchDbDocument}
 * @author martinfilliau
 */
public class ItemCouchDb extends CouchDbDocument {

    private String uri;
    
    private String title;
    
    private String author;
    
    private Date publishedAt;
    
    private Date retrievedAt;
    
    private List<String> content;
    
    private List<String> keywords;

    
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

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Date getRetrievedAt() {
        return retrievedAt;
    }

    public void setRetrievedAt(Date retrievedAt) {
        this.retrievedAt = retrievedAt;
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
    
}
