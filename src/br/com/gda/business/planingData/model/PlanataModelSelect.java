package br.com.gda.business.planingData.model;

import java.sql.Connection;

import javax.ws.rs.core.Response;

import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.planingData.model.decisionTree.RootPlanataSelect;
import br.com.gda.common.DbConnection;
import br.com.gda.common.DbSchema;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeFactory;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PlanataModelSelect implements Model {
	private Model helper;
	private Connection conn;
	private String schemaName;
	
	
	public PlanataModelSelect(PlanataInfo employeeInfo) {
		initialize();
		buildHelper(employeeInfo);
	}
	
	
	
	private void initialize() {
		this.conn = DbConnection.getConnection();
		this.schemaName = DbSchema.getDefaultSchemaName();
	}
	
	
	
	private void buildHelper(PlanataInfo employeeInfo) {
		ModelOption<PlanataInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = PlanataInfo.class;
		helperOption.decisionTreeFactory = new TreeFactory();
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
	
	
	
	
	
	
	private static class TreeFactory implements DeciTreeFactory<PlanataInfo> {		
		@Override public DeciTree<PlanataInfo> getInstance(DeciTreeOption<PlanataInfo> option) {
			return new RootPlanataSelect(option);
		}		
	}
}
