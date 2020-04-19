package br.com.mind5.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.glassfish.jersey.servlet.ServletContainer;

import br.com.mind5.common.DbConnection;
import br.com.mind5.servlet.db.DbMysql;


public class ServletMind5 extends ServletContainer {
	private static final long serialVersionUID = 1L;
	
	
	@Override public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		DataSource ds = initDataSource(config);
		shareDatasource(ds);
	}
	
	
	
	private DataSource initDataSource(ServletConfig config) {
		ServletContext context = config.getServletContext();
		DataSource ds = DbMysql.getDatasource(context);
		
		return ds;
	}
	
	
	
	private void shareDatasource(DataSource ds) {
		DbConnection.initialize(ds);
	}

	
	
	@Override public void destroy() {
		super.destroy();
		closeDatasource();		
	}
	
	
	
	private void closeDatasource() {
		DbConnection.closeDatasource();
	}
}
