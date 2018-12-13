package br.com.gda.business.userSnapshot.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.business.userSnapshot.model.decisionTree.RootUserSnapInsert;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class UserSnapModelInsert implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public UserSnapModelInsert(String incomingData) {
		initialize();
		buildHelper(incomingData);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(String incomingData) {
		ModelOption<UserSnapInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = UserSnapInfo.class;
		helperOption.decisionTreeFactory = new TreeFactory();
		helperOption.conn = this.conn;
		helperOption.schemaName = this.schemaName;
		
		helper = ModelHelper.factory(helperOption, incomingData);
	}


	
	@Override public boolean executeRequest() {
		return helper.executeRequest();
	}


	
	@Override public Response getResponse() {
		return helper.getResponse();
	}
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<UserSnapInfo> {		
		@Override public DeciTree<UserSnapInfo> getInstance(DeciTreeOption<UserSnapInfo> option) {
			return new RootUserSnapInsert(option);
		}			
	}
}
