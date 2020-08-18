package com.javahelps.jdbcbenchmark.profile;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Query {
    private final String connection;
    private final String script;
    private final String schema;
    private final String initStatement;
    private final boolean printOutput;

    @JsonCreator
    public Query(@JsonProperty("connection") String connection,
                 @JsonProperty("schema") String schema,
                 @JsonProperty("script") String script,
                 @JsonProperty("init_smt") String initStatement,
                 @JsonProperty("print_output") boolean printOutput) {
        this.connection = connection;
        this.schema = schema;
        this.script = script;
        this.initStatement = initStatement;
        this.printOutput = printOutput;
    }

    @JsonProperty
    public String getConnection() {
        return connection;
    }

    @JsonProperty
    public String getSchema() {
        return schema;
    }

    @JsonProperty
    public String getScript() {
        return script;
    }

    @JsonProperty
    public String getInitStatement() {
        return initStatement;
    }

    @JsonProperty
    public boolean isPrintOutput() {
        return printOutput;
    }

    @Override
    public String toString() {
        return "Query{" +
                "connection='" + connection + '\'' +
                ", script='" + script + '\'' +
                ", schema='" + schema + '\'' +
                ", printOutput=" + printOutput +
                '}';
    }
}
