package br.com.gda.security.jwtToken.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.jwtToken.info.JwtokenInfo;
import br.com.gda.security.jwtToken.model.decisionTree.RootJwtokenValidate;
public final class JwtokenModelValidate implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public JwtokenModelValidate(JwtokenInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(JwtokenInfo recordInfo) {
		ModelOption<JwtokenInfo> helperOption = new ModelOption<>();
		
		helperOption.recordClass = JwtokenInfo.class;
		helperOption.deciTreeFactory = new TreeFactory();
		helperOption.conn = this.conn;
		helperOption.schemaName = this.schemaName;
		
		helper = ModelHelper.factory(helperOption, recordInfo);
	}
	
	
	
	@Override public boolean executeRequest() {
		return helper.executeRequest();
	}


	
	@Override public Response getResponse() {
		return helper.getResponse();
	}
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<JwtokenInfo> {		
		@Override public DeciTree<JwtokenInfo> getInstance(DeciTreeOption<JwtokenInfo> option) {
			return new RootJwtokenValidate(option);
		}		
	}
}
