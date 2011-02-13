package com.martinfilliau.catchmystream.services;

import com.martinfilliau.catchmystream.dao.couchdb.CouchDbService;
import com.martinfilliau.catchmystream.dao.solr.SolrService;
import com.martinfilliau.catchmystream.data.couchdb.ItemCouchDb;
import com.martinfilliau.catchmystream.data.solr.ItemSolr;
import com.martinfilliau.catchmystream.data.ws.ItemRepresentation;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import org.apache.solr.client.solrj.SolrServerException;

/**
 *
 * @author martinfilliau
 */
@Stateless
@LocalBean
public class InsertIntoCms {
    
    @EJB
    private SolrService solr;
    
    @EJB
    private CouchDbService couchDb;
    
    public void insert(ItemRepresentation item) {
        Date publishedAt = new Date();
        Date retrievedAt = new Date();
        try {
            ItemCouchDb itemCouch = new ItemCouchDb();
            itemCouch.setAuthor(item.getAuthor());
            itemCouch.setContent(item.getContent());
            itemCouch.setKeywords(item.getKeywords());
            itemCouch.setPublishedAt(publishedAt);
            itemCouch.setRetrievedAt(retrievedAt);
            itemCouch.setTitle(item.getTitle());
            itemCouch.setUri(item.getUri());
            
            ItemSolr itemSolr = new ItemSolr();
            itemSolr.setAuthor(item.getAuthor());
            itemSolr.setContent(item.getContent());
            itemSolr.setKeywords(item.getKeywords());
            itemSolr.setPublishedDate(publishedAt);
            itemSolr.setTitle(item.getTitle());
            itemSolr.setUri(item.getUri());
            
            itemSolr.setiAmTheAuthor(false);    // TODO
            itemSolr.setSource("SOURCE");       // regarding source in couchdb

            solr.addItem(itemSolr);
            couchDb.insert(itemCouch);
        } catch (Exception ex) {
            Logger.getLogger(InsertIntoCms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
