package br.com.gda.business.employee.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.decisionTree.RootEmpInsert;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpModelInsert implements Model {
	private ModelHelper<EmpInfo> helper;
	private Connection conn;
	private String schemaName;
	
	
	public EmpModelInsert(String incomingData) {
		initialize();
		buildHelper(incomingData);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(String incomingData) {
		ModelOption<EmpInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = EmpInfo.class;
		helperOption.decisionTreeFactory = new TreeFactory();
		helperOption.conn = this.conn;
		helperOption.schemaName = this.schemaName;
		
		helper = new ModelHelper<>(helperOption, incomingData);
	}


	
	@Override public boolean executeRequest() {
		return helper.executeRequest();
	}


	
	@Override public Response getResponse() {
		return helper.getResponse();
	}
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<EmpInfo> {		
		@Override public DeciTree<EmpInfo> getInstance(DeciTreeOption<EmpInfo> option) {
			return new RootEmpInsert(option);
		}			
	}
}
