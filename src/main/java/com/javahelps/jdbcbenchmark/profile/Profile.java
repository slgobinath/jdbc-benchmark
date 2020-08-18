package com.javahelps.jdbcbenchmark.profile;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Profile {
    private final Map<String, JdbcConnection> connections;
    private final Map<String, Test> tests;

    @JsonCreator
    public Profile(@JsonProperty("connections") Map<String, JdbcConnection> connections,
                   @JsonProperty("tests") Map<String, Test> tests) {
        this.connections = connections;
        this.tests = tests;
    }

    @JsonProperty
    public Map<String, JdbcConnection> getConnections() {
        return connections;
    }

    @JsonProperty
    public Map<String, Test> getTests() {
        return tests;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "connections=" + connections +
                ", tests=" + tests +
                '}';
    }
}
