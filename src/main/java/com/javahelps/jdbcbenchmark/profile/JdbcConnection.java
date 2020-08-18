package com.javahelps.jdbcbenchmark.profile;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class JdbcConnection {
    private final String url;
    private final String username;
    private final String password;
    private final String initConnection;

    @JsonCreator
    public JdbcConnection(@JsonProperty("url") String url,
                          @JsonProperty("username") String username,
                          @JsonProperty("password") String password,
                          @JsonProperty("init_connection") String initConnection) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.initConnection = initConnection;
    }

    @JsonProperty
    public String getURL() {
        return url;
    }

    @JsonProperty
    public String getUsername() {
        return username;
    }

    @JsonProperty
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public String getInitConnection() {
        return initConnection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JdbcConnection that = (JdbcConnection) o;
        return Objects.equals(url, that.url) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(initConnection, that.initConnection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, username, password, initConnection);
    }

    @Override
    public String toString() {
        return "JdbcConnection{" +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", init='" + initConnection + '\'' +
                '}';
    }
}
