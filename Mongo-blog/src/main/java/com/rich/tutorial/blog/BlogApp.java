/** 
 * Project Name:Mongo-blog 
 * File Name:BlogApp.java 
 * Package Name:com.rich.tutorial.blog 
 * 
*/  
  
package com.rich.tutorial.blog;  

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.rich.tutorial.blog.controller.BlogController;

/** 
 * ClassName:BlogApp <br/> 
 * Function: Start Blog main class. <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
public class BlogApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(BlogApp.class);
    
//    private static final String MONGODB_DEFAULT_URI = "mongodb://localhost";
    private static final String MONGODB_DEFAULT_URI = "mongodb://rich:1234@ds039484.mongolab.com:39484/blog";
    private static final String MONGODB_DEFAULT_DB = "blog";

    public static void main(String[] args) {
        LOGGER.info("Start Blog app...");
        
        String mongoURI = MONGODB_DEFAULT_URI;
        String db = MONGODB_DEFAULT_DB;

        if (args.length > 0 && StringUtils.isNotBlank(args[0])) {
            mongoURI = args[0];
        }
        
        if (args.length > 1 && StringUtils.isNotBlank(args[1])) {
            db = args[1];
        }

        
        final MongoClient mongoClient = new MongoClient(new MongoClientURI(mongoURI));
        final MongoDatabase blogDatabase = mongoClient.getDatabase(db);
        
        try {
            new BlogController(blogDatabase);
            LOGGER.info("Initial BlogController finished, DB:{}", blogDatabase.getName());
        } catch (IOException e) {
            LOGGER.error("Initial BlogController error!", e);
        }
    }

}
  