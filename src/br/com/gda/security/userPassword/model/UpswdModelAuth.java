package br.com.gda.security.userPassword.model;

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
import br.com.gda.security.userPassword.info.UpswdInfo;
import br.com.gda.security.userPassword.model.decisionTree.RootUpswdAuth;

public final class UpswdModelAuth implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public UpswdModelAuth(UpswdInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(UpswdInfo recordInfo) {
		ModelOption<UpswdInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = UpswdInfo.class;
		helperOption.decisionTreeFactory = new TreeFactory();
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<UpswdInfo> {		
		@Override public DeciTree<UpswdInfo> getInstance(DeciTreeOption<UpswdInfo> option) {
			return new RootUpswdAuth(option);
		}		
	}
}
