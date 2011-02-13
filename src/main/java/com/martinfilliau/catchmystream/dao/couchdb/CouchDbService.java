package com.martinfilliau.catchmystream.dao.couchdb;

import com.martinfilliau.catchmystream.data.couchdb.ItemCouchDb;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;

/**
 * Manage connection to CouchDB database
 * @author martinfilliau
 */
@Stateless
@LocalBean
public class CouchDbService {
    
    // configuration of CouchDB host
    private static String COUCHDB_HOST = "localhost";
    private static int COUCHDB_PORT = 5984;
    private static String COUCHDB_DATABASE = "catchmystream";
    
    /**
     * Insert an item into the database
     * @param item 
     */
    public void insert(ItemCouchDb item) {
        HttpClient httpClient = new StdHttpClient.Builder()
                .host(COUCHDB_HOST)
                .port(COUCHDB_PORT)
                .build();
        
        CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
        CouchDbConnector db = new StdCouchDbConnector(COUCHDB_DATABASE, dbInstance);
        
        db.create(item);
    }
}
