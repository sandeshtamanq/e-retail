#!/bin/bash

# Navigate to the project directory
cd "$(dirname "$0")"

# Compile the Java source files
mvn clean compile

# Run the application
mvn exec:java -Dexec.mainClass="demo.DemoMain"