#!/bin/bash
sudo yum install tomcat -y
sudo yum install tomcat-webapps tomcat-admin-webapps -y
sudo yum install tomcat-docs-webapp tomcat-javadoc -y
systemctl status tomcat
systemctl restart tomcat
