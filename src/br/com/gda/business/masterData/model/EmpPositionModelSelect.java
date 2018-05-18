package br.com.gda.business.masterData.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.masterData.info.EmpPositionInfo;
import br.com.gda.business.masterData.model.decisionTree.EmpPositionRootSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpPositionModelSelect implements Model {
	private ModelHelper<EmpPositionInfo> helper;
	private Connection conn;
	private String schemaName;
	
	
	public EmpPositionModelSelect(EmpPositionInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(EmpPositionInfo recordInfo) {
		ModelOption<EmpPositionInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = EmpPositionInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<EmpPositionInfo> {		
		@Override public DeciTree<EmpPositionInfo> getDecisionTree(DeciTreeOption<EmpPositionInfo> option) {
			return new EmpPositionRootSelect(option);
		}		
	
	}
}
