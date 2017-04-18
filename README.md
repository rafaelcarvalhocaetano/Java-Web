# Projeto Front-End com java.

## Instalando o java 8


Acesse o link http://www.oracle.com/technetwork/pt/java/javase/downloads/index.html

Clique em Java Platform (JDK), escolha seu sistema operacional para instalação.

 ` Windows ` - Somente siga clicando em Next.

Configurando as Variáveis de ambiente.
 
```
INICIAR - (clique com o botão direito do mouse sobre simbolo do computador e escolha) PROPRIEDADE

CONFIGURAÇÔES AVANÇADAS DO SISTEMA - VARIÁVEIS DE AMBIENTE


```
Criando Variáveis de ambiente

```
Clique em "Novo"
 
 Nome da variável: JAVA_HOME
 Valor da Variável: C:\Program Files\Java\jdk1.8.0_111   (Caminho da Instalação do java)

```




## Instalando o eclipse
 
 Acesse o link https://www.eclipse.org/downloads/
 
 Escolha seu sistema operacional e a IDE eclipse JEE e siga clicando em next.

## Instalando o MySql

 Acesse o link https://dev.mysql.com/downloads/workbench/
 
 Após ter baixado, siga clicando em next
 
 
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
	
	<!-- Estágio do Projeto -->
	<context-param>
        <param-name>javax.faces.PROJECT_STAGE</param-name>
        <param-value>Development</param-value>
    </context-param>
    
    <servlet>
        <servlet-name>Faces Servlet</servlet-name>
        <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>Faces Servlet</servlet-name>
        <url-pattern>*.xhtml</url-pattern>
    </servlet-mapping>

    <!-- Carregamento do Hibernate -->
    <listener>
	<listener-class>br.com.drogaria.util.HibernateContexto</listener-class>
    </listener>

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
		<!-- Hibernate Core -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.2.9.Final</version>
		</dependency>

		<!-- Conector MySql -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>6.0.6</version>
		</dependency>

		<!-- Junit na Versão 4.12 e 11 aparecem erros-->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.10</version>  
		</dependency>
		
		<!-- JSF -->
		<dependency>
			<groupId>org.glassfish</groupId>
			<artifactId>javax.faces</artifactId>
			<version>2.2.12</version>
		</dependency>
		
		<!--PrimeFaces -->
		<dependency>
			<groupId>org.primefaces</groupId>
			<artifactId>primefaces</artifactId>
			<version>5.2</version>
		</dependency>

		<!-- OMNIFACES -->
		<dependency>
			<groupId>org.omnifaces</groupId>
			<artifactId>omnifaces</artifactId>
			<version>1.11</version>
		</dependency>

		<!-- Servlet -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>3.1.0</version>
		</dependency>

	</dependencies>
</project>

```

## Hibernate Config.


Configurando o arquivo hibernate.cfg.xml que fica dentro de src/main/resources

```
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

	<session-factory>

		<!-- Configurações de Conexão com o Banco de Dados -->
		<property name="connection.driver_class">com.mysql.jdbc.Driver</property>
		<property name="hibernate.connection.url">jdbc:mysql://127.0.0.1:3306/newdrogaria?useTimezone=true&amp;serverTimezone=UTC&amp;useSSL=false</property>
		<property name="connection.username">root</property>
		<property name="connection.password">q1w2e3r4</property>

		<!-- Pool de Conexões -->
		<property name="connection.pool_size">1</property>

		<!-- SQL dialect -->
		<property name="dialect">org.hibernate.dialect.MySQL5InnoDBDialect</property>

		<!-- Gerenciamento do Contexto das Sessões -->
		<property name="current_session_context_class">thread</property>

		<!-- Cache de Segundo Nível -->
		<property name="cache.provider_class">org.hibernate.cache.internal.NoCacheProvider</property>

		<!-- Mostra as SQLs Geradas -->
		<property name="show_sql">true</property>

		<!-- Cria as tabelas do banco de dados -->
		<property name="hbm2ddl.auto">create</property>
		
		<!-- Mapeamento das entidades -->
		
		<mapping class="br.com.drogaria.domain.Estado"/>
		<mapping class="br.com.drogaria.domain.Cidade" />
		<mapping class="br.com.drogaria.domain.Pessoa"/>
		<mapping class="br.com.drogaria.domain.Cliente" />
		<mapping class="br.com.drogaria.domain.Funcionario" />
		<mapping class="br.com.drogaria.domain.Usuario"/>
		
		<mapping class="br.com.drogaria.domain.Fabricante"/>
		<mapping class="br.com.drogaria.domain.Produto"/>
				
		<mapping class="br.com.drogaria.domain.Venda"/>
		<mapping class="br.com.drogaria.domain.ItemVenda"/>
		
	</session-factory>

</hibernate-configuration>

```
