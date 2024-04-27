package com.frank.generate;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

public class Main {
    public static void main(String[] args) throws MojoExecutionException, MojoFailureException {
        CodeGeneratorMojo generatorMojo = new CodeGeneratorMojo();
        generatorMojo.setDatabase("hotpot");
        generatorMojo.setModulePackage("com.frank.generate");
        generatorMojo.execute();
    }
}
