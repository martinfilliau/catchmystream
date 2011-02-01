package com.martinfilliau.catchmystream.data.ws;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author martinfilliau
 */
@XmlRootElement(name="item")
public class ItemRepresentation {

    @XmlAttribute(name="key", required=true)
    String authKey;
    
    @XmlElement(name="uri")
    String uri;
    
    @XmlElement(name="title")
    String title;
    
    @XmlElement(name="author")
    String author;
    
    @XmlElement(name="publishedDate")
    String publishedDate;   // TODO define format
    
    @XmlElement(name="content")
    List<String> content;
    
    @XmlElement(name="keywords")
    List<String> keywords;
}
