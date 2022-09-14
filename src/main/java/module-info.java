module springexam {
    requires java.sql;
    requires spring.aop;
    requires spring.beans;
    requires spring.jdbc;
    requires spring.context;
    requires spring.web;
    requires spring.core;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    // When you'd like to use the embedded tomcat.
    requires org.apache.tomcat.embed.core;
    requires spring.tx;
    requires lombok;
    requires org.slf4j;
    opens com.example.springexam;
}