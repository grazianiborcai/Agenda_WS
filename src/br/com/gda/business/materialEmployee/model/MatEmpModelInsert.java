package br.com.gda.business.materialEmployee.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.business.materialEmployee.model.decisionTree.RootMatEmpInsert;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatEmpModelInsert implements Model {
	private ModelHelper<MatEmpInfo> helper;
	private Connection conn;
	private String schemaName;
	
	
	public MatEmpModelInsert(String incomingData) {
		initialize();
		buildHelper(incomingData);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(String incomingData) {
		ModelOption<MatEmpInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = MatEmpInfo.class;
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<MatEmpInfo> {		
		@Override public DeciTree<MatEmpInfo> getInstance(DeciTreeOption<MatEmpInfo> option) {
			return new RootMatEmpInsert(option);
		}			
	}
}
