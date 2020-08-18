package com.javahelps.jdbcbenchmark.cli;

import picocli.CommandLine;

import java.io.File;

@CommandLine.Command(name = "jdbc-benchmark", description = "test and benchmark databases using JDBC connection")
public class BenchmarkCommand {
    @CommandLine.Option(names = "--profile", required = true, description = "profile yaml configuration")
    private File profile;

    @CommandLine.Option(names = "--output", description = "profile yaml configuration")
    private File output;

    @CommandLine.Option(names = "--help", usageHelp = true, description = "display this message and exit")
    private boolean helpRequested;

    public static BenchmarkCommand create(String[] args) {
        BenchmarkCommand command = new BenchmarkCommand();
        new CommandLine(command)
                .parseArgs(args);
        return command;
    }

    public File getProfile() {
        return profile;
    }

    public File getOutput() {
        return output;
    }

    public boolean isHelpRequested() {
        return helpRequested;
    }
}
