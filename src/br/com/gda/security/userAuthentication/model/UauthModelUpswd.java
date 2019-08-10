package br.com.gda.security.userAuthentication.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.obsolete.ModelHelper_;
import br.com.gda.model.obsolete.ModelOption_;
import br.com.gda.security.userAuthentication.info.UauthInfo;
import br.com.gda.security.userAuthentication.model.decisionTree.RootUauthUpswd;

public final class UauthModelUpswd implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public UauthModelUpswd(UauthInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(UauthInfo recordInfo) {
		ModelOption_<UauthInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = UauthInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<UauthInfo> {		
		@Override public DeciTree<UauthInfo> getInstance(DeciTreeOption<UauthInfo> option) {
			return new RootUauthUpswd(option);
		}		
	}
}
