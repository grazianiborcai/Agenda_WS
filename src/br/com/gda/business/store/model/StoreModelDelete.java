package br.com.gda.business.store.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.decisionTree.StoreRootDelete;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DecisionTree;
import br.com.gda.model.decisionTree.DecisionTreeFactory;
import br.com.gda.model.decisionTree.DecisionTreeOption;

public final class StoreModelDelete implements Model {
	private ModelHelper<StoreInfo> helper;
	private Connection conn;
	private String schemaName;
	
	
	public StoreModelDelete(StoreInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(StoreInfo recordInfo) {
		ModelOption<StoreInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = StoreInfo.class;
		helperOption.decisionTreeFactory = new TreeFactory();
		helperOption.conn = this.conn;
		helperOption.schemaName = this.schemaName;
		
		helper = new ModelHelper<>(helperOption, recordInfo);
	}


	
	@Override public boolean executeRequest() {
		return helper.executeRequest();
	}


	
	@Override public Response getResponse() {
		return helper.getResponse();
	}
	
	
	
	
	
	
	private static class TreeFactory implements DecisionTreeFactory<StoreInfo> {		
		@Override public DecisionTree<StoreInfo> getDecisionTree(DecisionTreeOption<StoreInfo> option) {
			return new StoreRootDelete(option);
		}		
	}
}
