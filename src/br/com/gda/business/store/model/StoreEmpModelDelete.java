package br.com.gda.business.store.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.store.info.StoreEmpInfo;
import br.com.gda.business.store.model.decisionTree.StoreEmpRootDelete;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DecisionTree;
import br.com.gda.model.decisionTree.DecisionTreeFactory;
import br.com.gda.model.decisionTree.DecisionTreeOption;

public final class StoreEmpModelDelete implements Model {
	private ModelHelper<StoreEmpInfo> helper;
	private Connection conn;
	private String schemaName;
	
	
	public StoreEmpModelDelete(StoreEmpInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(StoreEmpInfo recordInfo) {
		ModelOption<StoreEmpInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = StoreEmpInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DecisionTreeFactory<StoreEmpInfo> {		
		@Override public DecisionTree<StoreEmpInfo> getDecisionTree(DecisionTreeOption<StoreEmpInfo> option) {
			return new StoreEmpRootDelete(option);
		}		
	
	}
}
