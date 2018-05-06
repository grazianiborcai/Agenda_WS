package br.com.gda.business.employee.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.decisionTree.EmpRootDelete;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DecisionTree;
import br.com.gda.model.decisionTree.DecisionTreeFactory;
import br.com.gda.model.decisionTree.DecisionTreeOption;

public final class EmpModelDelete implements Model {
	private ModelHelper<EmpInfo> helper;
	private Connection conn;
	private String schemaName;
	
	
	public EmpModelDelete(EmpInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(EmpInfo recordInfo) {
		ModelOption<EmpInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = EmpInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DecisionTreeFactory<EmpInfo> {		
		@Override public DecisionTree<EmpInfo> getDecisionTree(DecisionTreeOption<EmpInfo> option) {
			return new EmpRootDelete(option);
		}		
	}
}
