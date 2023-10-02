package com.example.pos.connector.dbConnector;

import com.example.pos.connector.dbConnector.impl.MongoDBService;
import com.example.pos.connector.dbConnector.impl.MySQLDBService;

public class DatabaseFactory {
    public DBService getDatabaseService(String databaseType) {
        if ("MYSQL".equalsIgnoreCase(databaseType)) {
            return new MySQLDBService();
        }
        if ("MONGO".equalsIgnoreCase(databaseType)) {
            return new MongoDBService();
        }
        // Handle unsupported database types
        throw new IllegalArgumentException("Invalid database type: " + databaseType);
    }
}
