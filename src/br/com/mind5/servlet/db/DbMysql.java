package br.com.mind5.servlet.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public final class DbMysql {
	private final String DRIVER = "com.mysql.jdbc.Driver";	
	private DataSource datasource;
	
	public DbMysql(ServletContext sContext) {
		datasource = initDataSource(sContext);
	}
	
	
	
	private DataSource initDataSource(ServletContext sContext) {
		PoolProperties p = new PoolProperties();
		
		Properties prop = new Properties();
		InputStream input = null;

		try {

			String path =  sContext.getInitParameter("mysqlfile");
			input = sContext.getResourceAsStream(path);
			// load a properties file
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		String dburl = "jdbc:mysql://"+prop.getProperty("host")+":"+prop.getProperty("port")+"/";
		String dbUser = prop.getProperty("user");
		String dbPassword = prop.getProperty("password");

		p.setDefaultAutoCommit(false);
		p.setDefaultTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
		p.setFairQueue(true);
		p.setUrl(dburl);
		p.setDriverClassName(DRIVER);
		p.setUsername(dbUser);
		p.setPassword(dbPassword);
		p.setJmxEnabled(true);
		p.setTestWhileIdle(false);
		p.setTestOnBorrow(true);
		p.setValidationQuery("SELECT 1");
		p.setTestOnReturn(false);
		p.setValidationInterval(30000);
		p.setTimeBetweenEvictionRunsMillis(30000);
		p.setMaxActive(100);
		p.setInitialSize(10);
		p.setMaxWait(100);
		p.setRemoveAbandonedTimeout(60);
		p.setMinEvictableIdleTimeMillis(30000);
		p.setMinIdle(10);
		p.setMaxIdle(50);
		p.setLogAbandoned(true);
		p.setRemoveAbandoned(true);
		p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
				            + "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer;"
				            + "org.apache.tomcat.jdbc.pool.interceptor.ResetAbandonedTimer");
		DataSource d = new DataSource();
		d.setPoolProperties(p);

		return d;
	}
	
	
	
	public DataSource getDataSource() {
		return datasource;
	}
	
	
	
	public void close() {
		closeDatasource();
		clear();
	}
	
	
	
	public void closeDatasource() {
		if (datasource == null)
			return;
		
		datasource.close();
	}
	
	
	
	private void clear() {
		datasource = null;
	}
}
