package br.com.mind5.security.jwtToken.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.mind5.common.DbConnection;
import br.com.mind5.common.DbSchema;
import br.com.mind5.model.Model;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeFactory;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.obsolete.ModelHelper_;
import br.com.mind5.model.obsolete.ModelOption_;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.model.decisionTree.RootJwtokenValidate;
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
		ModelOption_<JwtokenInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = JwtokenInfo.class;
		helperOption.deciTreeFactory = new TreeFactory();
		helperOption.conn = this.conn;
		helperOption.schemaName = this.schemaName;
		
		helper = ModelHelper_.factory(helperOption, recordInfo);
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
