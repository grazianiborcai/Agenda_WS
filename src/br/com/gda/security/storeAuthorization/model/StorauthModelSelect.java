package br.com.gda.security.storeAuthorization.model;

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
import br.com.gda.security.storeAuthorization.info.StorauthInfo;
import br.com.gda.security.storeAuthorization.model.decisionTree.RootStorauthSelect;
public final class StorauthModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public StorauthModelSelect(StorauthInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(StorauthInfo recordInfo) {
		ModelOption_<StorauthInfo> helperOption = new ModelOption_<>();
		
		helperOption.recordClass = StorauthInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<StorauthInfo> {		
		@Override public DeciTree<StorauthInfo> getInstance(DeciTreeOption<StorauthInfo> option) {
			return new RootStorauthSelect(option);
		}		
	}
}
