package br.com.gda.security.tokenAuthentication.model;

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
import br.com.gda.security.tokenAuthentication.info.TauthInfo;
import br.com.gda.security.tokenAuthentication.model.decisionTree.RootTauthToken;

public final class TauthModelToken implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public TauthModelToken(TauthInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(TauthInfo recordInfo) {
		ModelOption<TauthInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = TauthInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<TauthInfo> {		
		@Override public DeciTree<TauthInfo> getInstance(DeciTreeOption<TauthInfo> option) {
			return new RootTauthToken(option);
		}		
	}
}
