# COIT20258-Assignment-3-NNS
This repository contains the source codes of the Hospital Management System as a part of assignment 3 of Software Engineering. 2023


The following is the pom.xml of the initial setup:

////////////////
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com</groupId>
    <artifactId>HospitalManagementSystem</artifactId>
    <version>1.0.0</version>
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-controls</artifactId>
            <version>13</version>
        </dependency>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-fxml</artifactId>
            <version>13</version>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.0</version>
                <configuration>
                    <release>11</release>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.openjfx</groupId>
                <artifactId>javafx-maven-plugin</artifactId>
                <version>0.0.4</version>
                <configuration>
                    <mainClass>com.hospitalmanagementsystem.App</mainClass>
                </configuration>
                <executions>
                    <execution>
                        <!-- Default configuration for running -->
                        <!-- Usage: mvn clean javafx:run -->
                        <id>default-cli</id>
                    </execution>
                    <execution>
                        <!-- Configuration for manual attach debugging -->
                        <!-- Usage: mvn clean javafx:run@debug -->
                        <id>debug</id>
                        <configuration>
                            <options>
                                <option>-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=localhost:8000</option>
                            </options>
                        </configuration>
                    </execution>
                    <execution>
                        <!-- Configuration for automatic IDE debugging -->
                        <id>ide-debug</id>
                        <configuration>
                            <options>
                                <option>-agentlib:jdwp=transport=dt_socket,server=n,address=${jpda.address}</option>
                            </options>
                        </configuration>
                    </execution>
                    <execution>
                        <!-- Configuration for automatic IDE profiling -->
                        <id>ide-profile</id>
                        <configuration>
                            <options>
				<option>${profiler.jvmargs.arg1}</option>
				<option>${profiler.jvmargs.arg2}</option>
				<option>${profiler.jvmargs.arg3}</option>
				<option>${profiler.jvmargs.arg4}</option>
				<option>${profiler.jvmargs.arg5}</option>
                            </options>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>


///////////////
