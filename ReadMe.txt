проект выполнен с использованием jdk-1.8.0_201
тестировался с БД MySQL 8.0.16
зависимости можно посмотреть в pom.xml
для запуска проекта использовался Apache Tomcat 9.0.27(в TomCat нужно указать war artifact)

Так же нужно изменить в src/main/java/com/taskDistributor/config/SpringConfig.java путь, логин, пароль, (драйвер) для БД

Прежде чем запускать приложение нужно создать mySql таблицу:

CREATE TABLE task
(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    assignee varchar(55),
    summary varchar(999),
    startDate DATE,
    endDate DATE
);
CREATE UNIQUE INDEX task_id_uindex ON task (id);

ссылка на предыдущий проект с использованием spring CrudRepository: https://github.com/NoBrakes1991/taskDistributor