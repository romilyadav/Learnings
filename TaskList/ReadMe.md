The project is simple Task list management system built to display the use of REST api. The following technologies has been used:
1. Spring
2. AngularJS
3. Maven
4. JDK
5. Eclipse
6. PostgreSQL
7. JDBC
The application runs on Apache Tomcat server. Maven is used to build the war file.
As of 8/20/2017, the application does not have front end page to access the list. The application has been tested by writing service calls from AngularJS when the home page is loaded. The database is made up of the following two tables:
1. tasklist
2. userlist.
The create statements are:

CREATE TABLE taskdb.tasklist
(
  taskid integer NOT NULL,
  taskdescription character varying(30) NOT NULL,
  taskcompletionstatus character(1) NOT NULL,
  userid integer NOT NULL,
  CONSTRAINT tasklistkey PRIMARY KEY (taskid),
  CONSTRAINT tasklistuser FOREIGN KEY (userid)
      REFERENCES taskdb.userlist (userid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

CREATE TABLE taskdb.userlist
(
  userid integer NOT NULL,
  username character varying(30) NOT NULL,
  userdescription character varying(60) NOT NULL,
  CONSTRAINT userkey PRIMARY KEY (userid),
  CONSTRAINT usernameunque UNIQUE (username)
)

The database also has two sequences that are used to generate the ids.