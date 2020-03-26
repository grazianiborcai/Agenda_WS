package br.com.mind5.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.glassfish.jersey.servlet.ServletContainer;

import br.com.mind5.common.DbConnection;
import br.com.mind5.servlet.db.DbMysql;



public class ServletMind5 extends ServletContainer {
	private static final long serialVersionUID = 1L;
	private DbMysql db;
	
	
	@Override public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		db = initDataSource(config);
		shareDataSource(db);
	}
	
	
	
	private DbMysql initDataSource(ServletConfig config) {
		ServletContext context = config.getServletContext();
		DbMysql mysql = new DbMysql(context);
		
		return mysql;
	}
	
	
	
	private void shareDataSource(DbMysql mysql) {
		DbConnection.initialize(mysql.getDataSource());
	}

	
	
	@Override public void destroy() {
		super.destroy();
		db.close();
	}
}
