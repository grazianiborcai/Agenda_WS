package br.com.gda.business.employeeWorkTimeConflict.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.gda.business.employeeWorkTimeConflict.model.decisionTree.RootEmpwocoSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpwocoModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public EmpwocoModelSelect(EmpwocoInfo recordInfo) {
		initialize();
		buildHelper(recordInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(EmpwocoInfo recordInfo) {
		ModelOption<EmpwocoInfo> helperOption = new ModelOption<>();
		
		helperOption.recordClass = EmpwocoInfo.class;
		helperOption.deciTreeFactory = new TreeFactory();
		helperOption.conn = this.conn;
		helperOption.schemaName = this.schemaName;
		
		helper = ModelHelper.factory(helperOption, recordInfo);
	}


	
	@Override public boolean executeRequest() {
		return helper.executeRequest();
	}


	
	@Override public Response getResponse() {
		return helper.getResponse();
	}
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<EmpwocoInfo> {		
		@Override public DeciTree<EmpwocoInfo> getInstance(DeciTreeOption<EmpwocoInfo> option) {
			return new RootEmpwocoSelect(option);
		}			
	}
}
