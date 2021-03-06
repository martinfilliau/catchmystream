package com.martinfilliau.catchmystream.data.ws;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Web service (input) view of an item
 * @author martinfilliau
 */
@XmlRootElement(name="item")
public class ItemRepresentation {

    @XmlAttribute(name="key", required=true)
    private String authKey;     // key of the authorized feeder
    
    @XmlElement(name="uri")
    private String uri;
    
    @XmlElement(name="title")
    private String title;
    
    @XmlElement(name="author")
    private String author;
    
    @XmlElement(name="publishedDate")
    private String publishedDate;   // TODO define format
    
    @XmlElement(name="content")
    private List<String> content;
    
    @XmlElement(name="keywords")
    private List<String> keywords;

    
    /* GETTERs and SETTERs */
    
    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

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
}
