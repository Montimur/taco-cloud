module net.montimur.tacocloud {

    requires java.xml;
    requires java.sql;

    requires spring.core;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.beans;
    requires spring.web;
    requires spring.webmvc;

    opens net.montimur.tacocloud to spring.boot.devtools, spring.core, spring.beans, spring.context;
    opens net.montimur.tacocloud.controller to spring.beans, spring.context;
}