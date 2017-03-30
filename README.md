# Projeto Front-End com java.

## Instalando o java 8
## Instalando o eclipse
## Instalando o MySql
## Baixando os jar necessários através do Maven

Criar um pasta `WEB-INF` para conter `web.xml`

```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns="http://xmlns.jcp.org/xml/ns/javaee"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
	id="WebApp_ID" version="3.1">

	<!-- Nome da Aplicação -->
	<display-name>Drogaria</display-name>
</web-app>

``` 

Gerando aplicação para final `Maven Install`


Configurando o pom.xml

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>br.com.drogaria</groupId>
	<artifactId>Drogaria</artifactId>
	<version>1.0</version>
	<packaging>war</packaging>

	<!-- Codificação dos caracteres -->
	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	</properties>

	<!-- Parâmetros de execução -->
	<build>
		<!-- Nome do projeto empacotado -->
		<finalName>Drogaria</finalName>

		<!-- Plugins -->
		<plugins>
			<!-- Compilador -->
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.3</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
				</configuration>
			</plugin>
		</plugins>
	</build>

	<!-- Dependências necessárias -->
	<dependencies>
		<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.2.9.Final</version>
		</dependency>
	</dependencies>
</project>

```

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
