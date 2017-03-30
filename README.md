# Projeto Front-End com java.

## Instalando o java 8
## Instalando o eclipse
## Instalando o MySql
## Baixando os .jar necessários através do Maven
## Hibernate Config.

Configurando o arquivo hibernate.cfg.xml que fica dentro de src/main/resources

```
<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

    <session-factory>

        <!-- Configurações com banco de dados -->
        <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="connection.url">jdbc:mysql://127.0.0.1:3306/newdrogaria</property>
        <property name="connection.username">root</property>
        <property name="connection.password">q1w2e3r4</property>

        <!-- JDBC connection pool (use the built-in) quantidade de conexões -->
        <property name="connection.pool_size">1</property>

        <!-- SQL dialect -->
        <property name="dialect">org.hibernate.dialect.MySql5InnoDBDialect</property>

        <!-- Enable Hibernate's automatic session context management -->
        <property name="current_session_context_class">thread</property>

        <!-- Disable the second-level cache  -->
        <property name="cache.provider_class">org.hibernate.cache.internal.NoCacheProvider</property>

        <!-- Echo all executed SQL to stdout -->
        <property name="show_sql">true</property>

        <!-- Drop and re-create the database schema on startup -->
        <property name="hbm2ddl.auto">create</property>

    </session-factory>

</hibernate-configuration>

```