package br.com.gda.business.employeeList.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.employeeList.model.decisionTree.RootEmplisSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmplisModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public EmplisModelSelect(EmplisInfo employeeInfo) {
		initialize();
		buildHelper(employeeInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(EmplisInfo employeeInfo) {
		ModelOption<EmplisInfo> helperOption = new ModelOption<>();
		
		helperOption.recordClass = EmplisInfo.class;
		helperOption.deciTreeFactory = new TreeFactory();
		helperOption.conn = this.conn;
		helperOption.schemaName = this.schemaName;
		
		helper = ModelHelper.factory(helperOption, employeeInfo);
	}
	
	
	
	@Override public boolean executeRequest() {
		return helper.executeRequest();
	}


	
	@Override public Response getResponse() {
		return helper.getResponse();
	}
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<EmplisInfo> {		
		@Override public DeciTree<EmplisInfo> getInstance(DeciTreeOption<EmplisInfo> option) {
			return new RootEmplisSelect(option);
		}		
	}
}
