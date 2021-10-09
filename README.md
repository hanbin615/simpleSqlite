# simpleSqlite

## AIM
The aim of this project is to show how to set up Spring boot with SQLite as database.

## CONTENT
This is a simple console program that use SQLite.

Since hibernate doesn't provide dialect for SQLite, in the past one had to spend time writing it, but now you can just look or ask around.

see https://stackoverflow.com/questions/17587753/does-hibernate-fully-support-sqlite

## CONCLUSION
in order to use SQLite like any other database you have to:
1. add a dependency that provide SQLite dilect
2. in application.properties add hibernate.dialect 