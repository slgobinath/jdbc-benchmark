package com.javahelps.jdbcbenchmark.profile;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Test {
    private final TestType type;
    private final int count;
    private final List<Query> queries;

    @JsonCreator
    public Test(@JsonProperty("type") TestType type,
                @JsonProperty("count") int count,
                @JsonProperty("queries") List<Query> queries) {
        this.type = type;
        this.count = count;
        this.queries = queries;
    }

    @JsonProperty
    public TestType getType() {
        return type;
    }

    @JsonProperty
    public int getCount() {
        return count;
    }

    @JsonProperty
    public List<Query> getQueries() {
        return queries;
    }

    @Override
    public String toString() {
        return "Test{" +
                "type=" + type +
                ", count=" + count +
                ", queries=" + queries +
                '}';
    }
}
