package br.com.gda.business.masterData.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.masterData.info.PositionInfo;
import br.com.gda.business.masterData.model.decisionTree.PositionRootSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DecisionTree;
import br.com.gda.model.decisionTree.DecisionTreeFactory;
import br.com.gda.model.decisionTree.DecisionTreeOption;

public final class PositionModelSelect implements Model {
	private ModelHelper<PositionInfo> helper;
	private Connection conn;
	private String schemaName;
	
	
	public PositionModelSelect(PositionInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(PositionInfo recordInfo) {
		ModelOption<PositionInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = PositionInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DecisionTreeFactory<PositionInfo> {		
		@Override public DecisionTree<PositionInfo> getDecisionTree(DecisionTreeOption<PositionInfo> option) {
			return new PositionRootSelect(option);
		}		
	
	}
}
