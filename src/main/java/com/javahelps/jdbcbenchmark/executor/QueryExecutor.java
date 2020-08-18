package com.javahelps.jdbcbenchmark.executor;

import com.javahelps.jdbcbenchmark.io.FileReader;
import com.javahelps.jdbcbenchmark.profile.JdbcConnection;

import java.io.IOException;
import java.sql.*;
import java.util.function.BiFunction;

import static java.util.Objects.requireNonNull;

public class QueryExecutor implements AutoCloseable {

    private final Connection connection;

    public QueryExecutor(JdbcConnection jdbcConnection) throws SQLException, IOException {
        this.connection = DriverManager.getConnection(jdbcConnection.getURL(), jdbcConnection.getUsername(), jdbcConnection.getPassword());
        initialize(this.connection, jdbcConnection);
    }

    protected static void initialize(Connection connection, JdbcConnection jdbcConnection) throws SQLException, IOException {
        if (jdbcConnection.getInitConnection() != null) {
            String sql = FileReader.read(jdbcConnection.getInitConnection());
            try (Statement statement = connection.createStatement()) {
                statement.execute(sql);
            }
        }
    }

    public <T> T execute(String schema, String initSql, String sql, BiFunction<Long, ResultSet, T> mapper) throws SQLException {
        requireNonNull(sql, "sql is null");
        requireNonNull(mapper, "mapper is null");
        try (Statement statement = connection.createStatement()) {
            if (initSql != null) {
                // Initialize the statement
                statement.execute(initSql);
            }
            if (schema != null) {
                // Initialize the statement
                statement.execute("USE " + schema);
            }
            // Execute the sql query
            long startTime = System.currentTimeMillis();
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                return mapper.apply(startTime, resultSet);
            }
        }
    }

    @Override
    public void close() throws SQLException {
        this.connection.close();
    }
}
