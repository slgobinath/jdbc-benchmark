package com.javahelps.jdbcbenchmark.executor;

import com.javahelps.jdbcbenchmark.profile.JdbcConnection;
import com.javahelps.jdbcbenchmark.profile.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ProfileExecutor implements AutoCloseable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileExecutor.class);

    private final Map<JdbcConnection, QueryExecutor> queryExecutors = new HashMap<>();

    public void execute(Profile profile) {
        // Initialize connections
    }

    private synchronized QueryExecutor getQueryExecutor(JdbcConnection connection) throws IOException, SQLException {
        QueryExecutor executor = this.queryExecutors.get(connection);
        if (executor == null) {
            executor = new QueryExecutor(connection);
            this.queryExecutors.put(connection, executor);
        }
        return executor;
    }

    @Override
    public void close() {
        for (Map.Entry<JdbcConnection, QueryExecutor> entry : this.queryExecutors.entrySet()) {
            try {
                entry.getValue().close();
            } catch (SQLException ex) {
                LOGGER.error("Failed to close the connection " + entry.getKey().getURL(), ex);
            }
        }
    }
}
