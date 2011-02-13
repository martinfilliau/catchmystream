package com.martinfilliau.catchmystream.dao.solr;

import com.martinfilliau.catchmystream.data.solr.ItemSolr;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;

/**
 * Service to access a Solr instance
 * @author martinfilliau
 */
@Stateless
@LocalBean
public class SolrService {
    
    /**
     * URL of the Solr instance to use
     */
    private final static String SOLR_URL = "http://localhost:8983/solr";
    
    /**
     * Get an instance of a Solr server
     * @return
     * @throws MalformedURLException 
     */
    private SolrServer getSolrServer() throws MalformedURLException {
        return new CommonsHttpSolrServer(SOLR_URL);
    }

    /**
     * Add a {@link com.martinfilliau.catchmystream.data.solr.ItemSolr} to the solr instance
     * NOTE: it also commits
     * @param item
     * @throws MalformedURLException
     * @throws IOException
     * @throws SolrServerException 
     */
    public void addItem(ItemSolr item) throws MalformedURLException, IOException, SolrServerException {
        SolrServer server = getSolrServer();
        server.addBean(item);
        server.commit();
    }
    
    /**
     * Delete everything in Solr indexes
     * WARNING: this should be used with great caution
     * @throws MalformedURLException
     * @throws SolrServerException
     * @throws IOException 
     */
    private void deleteEverything() throws MalformedURLException, SolrServerException, IOException {
        getSolrServer().deleteByQuery("*:*");
    }
    
}
