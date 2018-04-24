package br.com.gda.employee.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.employee.info.EmpInfo;
import br.com.gda.employee.model.decisionTree.EmpRootSelect;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DecisionTree;
import br.com.gda.model.decisionTree.DecisionTreeFactory;
import br.com.gda.model.decisionTree.DecisionTreeOption;

public final class EmpModelSelect implements Model {
	private ModelHelper<EmpInfo> helper;
	private Connection conn;
	private String schemaName;
	
	
	public EmpModelSelect(EmpInfo employeeInfo) {
		initialize();
		buildHelper(employeeInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(EmpInfo employeeInfo) {
		ModelOption<EmpInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = EmpInfo.class;
		helperOption.decisionTreeFactory = new TreeFactory();
		helperOption.conn = this.conn;
		helperOption.schemaName = this.schemaName;
		
		helper = new ModelHelper<>(helperOption, employeeInfo);
	}
	
	
	
	@Override public boolean executeRequest() {
		return helper.executeRequest();
	}


	
	@Override public Response getResponse() {
		return helper.getResponse();
	}
	
	
	
	
	
	
	private static class TreeFactory implements DecisionTreeFactory<EmpInfo> {		
		@Override public DecisionTree<EmpInfo> getDecisionTree(DecisionTreeOption<EmpInfo> option) {
			return new EmpRootSelect(option);
		}		
	
	}
}
